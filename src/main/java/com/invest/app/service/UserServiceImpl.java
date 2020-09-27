package com.invest.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invest.app.model.Users;
import com.invest.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
private UserRepository userRepository;	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public Optional<Users> findById(Long id) {
		return userRepository.findById(id);
	}
	@Override
	public Optional<Users> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public Optional<Users> login(String email, String password) {
		return userRepository.login(email, password);
	}
	
	@Override
	public List<Users> findByName(String name) {
		return userRepository.findByFname(name);
	}
	
	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	@Override
	public void updateUser(Users user) {
		userRepository.findById(user.getId()).ifPresent(a->{
			a.setFname(user.getFname());
			a.setLname(user.getLname());			
		});
	}
	@Override
	public void updateRole(String role, Long id) {
		userRepository.findById(id).ifPresent(a->{
			a.setRole(role);			
		});	
		
	}
	@Override
	public void resetpassword(String password, Long id) {
		userRepository.findById(id).ifPresent(a->{
			a.setPassword(password);			
		});
	}
	@Override
	public void save(Users user) {
		userRepository.save(user);
	}
	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	@Override
	public Optional<Users> findById(String id) {
		return userRepository.findById(id);
	}
}
