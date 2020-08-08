package web.initialize.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.initialize.entity.UserEntity;
import web.initialize.repository.UserRepository;
import web.initialize.security.bcrypt.BcryptUtil;

@RestController
public class AuthenticationController {
	@Autowired
	UserRepository UserRepository;

	@RequestMapping("/")
	public String homePage() {
		return "Home";
	}

	@RequestMapping("/admin")
	public String adminPage() {
		return "Admin Page";
	}

	@RequestMapping("/user")
	public String userPage() {
		return "User Page";
	}

	@RequestMapping("/success")
	public String loginSuccess() {
		return "Log in Success";
	}

	@RequestMapping("/failed")
	public String loginFailed() {
		return "Log in failed";
	}

	@RequestMapping("/logoutsuccess")
	public String logout() {
		return "Logout success";
	}

	@RequestMapping("/bcrypt")
	public String bcrypt() {
		return BcryptUtil.encoder("user");
	}

	@RequestMapping("/errorPage")
	public String errorPage() {
		return "errorPage";
	}

	@RequestMapping("/check")
	public String check() {
		return "check";
	}

	@RequestMapping("/all")
	public List<UserEntity> all() {
		return UserRepository.findAll();
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/get-data")
	public List<UserEntity> getData() {
		
		return this.UserRepository.findAllByUserIn(new ArrayList<>());
	}
}
