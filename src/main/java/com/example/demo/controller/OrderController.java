package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Login;
import com.example.demo.model.Cart;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class OrderController {

	@Autowired
	Cart cart;

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/order")
	public String order() {
		return "order";
	}

	@PostMapping("/order")
	public String orderCustomer(
			@RequestParam(name = "userName", defaultValue = "") String userName,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "address", defaultValue = "") String address,
			Model model) {

		Login login = new Login(userName, email, address);
		model.addAttribute("login", login);
		loginRepository.save(login);

		return "order";
	}

	@GetMapping("/thankyou")
	public String thankyou() {
		return "thankyou";
	}
}
