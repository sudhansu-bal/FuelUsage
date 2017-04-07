package com.mf.fuel.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mf.fuel.api.dto.UserViewDto;

/**
 * Rest controller for user
 * @author sudhansub
 *
 */
@RestController
public class UserController {

	@GetMapping("/api/user")
	public UserViewDto getUser(){
		Logger logger = LogManager.getLogger(UserController.class);
		logger.info("in user api");
		System.out.println("in user api .............");
	return new UserViewDto();
}
}
