package com.healthcare.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.healthcare.entity.User;
import com.healthcare.exceptions.UserException;
import com.healthcare.repo.UserRepository;
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository; 
	public String userlogin(String userName,String userPassword) throws UserException
	{
		Optional<User> optSer=userRepository.findByUserName(userName);
		if(optSer.isPresent()) {
			if(optSer.get().getUserPassword().equals(userPassword)) {
				return "Login Successfull";
			}else {
				return "Invalid Password";
			}
		}
		return "Invalid UserName";
		
	}
	@Transactional(readOnly = false)
	public String userRegister(User user)throws UserException {
		User r=userRepository.save(user);
		return "User Register Succssfully";
	}
	
}
