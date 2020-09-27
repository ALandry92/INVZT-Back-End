package com.invest.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.invest.app.dto.ApiData;
import com.invest.app.dto.UserDto;
import com.invest.app.model.Portfolio;
import com.invest.app.model.StockObserver;
import com.invest.app.model.Users;
import com.invest.app.repository.PortfolioRepository;
import com.invest.app.repository.StockObserverRepository;
import com.invest.app.repository.UserRepository;
import com.invest.app.service.YahooApiDataService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestApiController {

	private final Logger log = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private PortfolioRepository portfolioRepository;
	@Autowired
	private StockObserverRepository stockObserverRepository;

	@Autowired
	private YahooApiDataService yahooApi;
	
	@RequestMapping(value = "/submitUserDetails", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void submitUserDetails(@RequestBody Users user) {
		userRepository.save(user);
	}

	@RequestMapping(value = "/findUserId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Users>> findByEmail(String email) {
		Optional<Users> user = userRepository.findById(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAllUsers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Users>> findAllUsers() {
		List<Users> allUsers = userRepository.findAll();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@RequestMapping(value = "/userLogIn", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	private ResponseEntity<Users> userLogIn(@RequestBody UserDto userDto) {
		Optional<Users> user = userRepository.findByEmail(userDto.getEmail());
		if (user.isPresent()) {
			Users login = user.get();
			if (login.getPassword().equals(userDto.getPassword())) {
				return new ResponseEntity<>(login, HttpStatus.OK);
			}

		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		log.info("Request to get all Users: {}", userRepository.findAll());
		return userRepository.findAll();

	}

	@GetMapping("/user/{email}")
	ResponseEntity<?> getUser(@PathVariable String email) {
		Optional<Users> user = userRepository.findByEmail(email);
		return user.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/user")
	ResponseEntity<Users> createUser(@RequestBody Users user) throws URISyntaxException {
		log.info("Request to create User: {}", user);
		Users result = userRepository.save(user);
		return ResponseEntity.created(new URI("/api/user/" + result.getId())).body(result);
	}

	@PutMapping("/user/{id}")
	ResponseEntity<Users> updateUsers(@RequestBody Users user) {
		log.info("Request to update user: {}", user);
		Users result = userRepository.save(user);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		log.info("Request to delete user: {}", id);
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/stock/{ticker}")
	public ResponseEntity<ApiData> getStockData(@PathVariable String ticker) {
		log.info("Getting stock data for ticker: {}", ticker);

		return new ResponseEntity<ApiData>(yahooApi.getStockData(ticker), HttpStatus.OK);
	}
	
	@PostMapping("/create/portfolio/{email}")
	public List<Portfolio> createPortfolio(@PathVariable String email, @RequestBody Portfolio portfolio) {
		
		Optional<Users> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			portfolio.setPostedBy(user.get());
			portfolioRepository.save(portfolio);
			return portfolioRepository.findAllByPostedBy(user.get());
		}
		return new ArrayList<>();
	}
	
	@PostMapping("/portfolio/{portfolioId}/add-stock")
	public  Portfolio  addToPortfolio(@PathVariable Long portfolioId, @RequestBody StockObserver stock) {

		Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
		
		if(portfolio.isPresent()) {
			stock.setStockPortforlio(portfolio.get());
			stock.setPostedBy(portfolio.get().getPostedBy());
			stockObserverRepository.save(stock);
		}
		
		return  portfolioRepository.findById(portfolioId).get();
	}
	
	@GetMapping("/findPortfolios/{email}")
	public  List<Portfolio>   findPortfolios(@PathVariable String email) {
		
		Optional<Users> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			return portfolioRepository.findAllByPostedBy(user.get());
		}
		return new ArrayList<>();
	}
	
	@GetMapping("/findPortfolioStocks/{portfolioId}")
	public  List<StockObserver>   findPortfindPortfolioStocksfolios(@PathVariable Long portfolioId) {

		Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
		if(portfolio.isPresent()) {
			return stockObserverRepository.findAllByStockPortforlio(portfolio.get());
		}
		return new ArrayList<>();
	}
	
	@PostMapping("/delete-stock/{stockId}")
	public  void  addToPortfolio(@PathVariable Long stockId) {
		stockObserverRepository.deleteById(stockId);
	}
	
}
