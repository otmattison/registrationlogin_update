package com.hcl.registerlogin.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.registerlogin.crud.UserCrudRepository;
import com.hcl.registerlogin.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {

	@Autowired
	UserCrudRepository myCrudRepository;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping(path = "/register")
	public String register() {
		return "register";
	}

	@PostMapping(path = "/register-succesful")
	public String successfulRegister(User user) {
		myCrudRepository.save(user);
		return "register-succesful";
	}

	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}

	@PostMapping(path = "/login-succesful")
	public String successfulLogin(User userLogin) {
		Iterable<User> userInfo = myCrudRepository.findAll();
		for (User user : userInfo) {
			if (user.getUsername().equals(userLogin.getUsername())
					&& user.getPassword().equals(userLogin.getPassword())) {
				return "login-succesful";
			} else {
				return "failedlogin";
			}
		}
		return "login-succesful";
	}

	@GetMapping(path = "/update")
	public String update() {
		return "update";
	}

	@PostMapping(path = "/update2")
	public String updateUser(User user) {
		Long tempid = user.getId();
		if (myCrudRepository.existsById(tempid)) {
			myCrudRepository.save(user);
			logger.info("user saved");
			return "update2";
		} else
			return "error";

	}
	@ExceptionHandler({IOException.class, java.sql.SQLException.class})
    public ModelAndView handleIOException(Exception ex) {
        ModelAndView model = new ModelAndView("IOError");
 
        model.addObject("exception", ex.getMessage());
         
        return model;
    }

}
