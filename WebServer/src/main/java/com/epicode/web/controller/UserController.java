package com.epicode.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epicode.web.model.User;
import com.epicode.web.repositories.UserDaoRepository;
import com.epicode.web.service.UserService;

@Controller
public class UserController {
	@Autowired UserDaoRepository u;
	@Autowired UserService s;
	
	@GetMapping("/")
	public String homePage() {
		return "user";
	}
	
	@GetMapping("/chi")
	public ModelAndView chiSono() {
		List <User> us = s.getAll();
		System.out.println(us.size());
		 ModelAndView model = new ModelAndView("Chi-Sono");
		 model.addObject("lista",us);
		return model;
	}

	@GetMapping("/users/{id}")
	public ModelAndView getRubrica(@PathVariable Long id) {
	    ModelAndView model = new ModelAndView("usersId");
	    Optional<User> optionalUser = s.getUser(id);
	    User user = optionalUser.orElse(new User());
	    model.addObject("user", user);
	    return model;
	}



}

