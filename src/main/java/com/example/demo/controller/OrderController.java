package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cart;

@Controller
public class OrderController {

	@Autowired
	Cart cart;

	//	@Autowired
	//	LoginRepository loginRepository;
	//
	//	@Autowired
	//	OrderRepository orderRepository;

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

		// 全てが空の場合にエラーとする
		if (userName.equals("") && email.equals("") && address.equals("")) {
			model.addAttribute("message", "名前を入力してください");
			model.addAttribute("mailmessage", "メールアドレスを入力してください");
			model.addAttribute("addmessage", "住所を入力してください");

			return "order";
		}

		// 名前とメールアドレスが空の場合にエラーとする
		if (userName.equals("") && email.equals("")) {
			model.addAttribute("message", "名前を入力してください");
			model.addAttribute("mailmessage", "メールアドレスを入力してください");

			return "order";
		}

		// 名前と住所が空の場合にエラーとする
		if (userName.equals("") && address.equals("")) {
			model.addAttribute("message", "名前を入力してください");
			model.addAttribute("addmessage", "住所を入力してください");

			return "order";
		}

		// メールアドレスと住所が空の場合にエラーとする
		if (email.equals("") && address.equals("")) {
			model.addAttribute("mailmessage", "メールアドレスを入力してください");
			model.addAttribute("addmessage", "住所を入力してください");

			return "order";
		}
		// 名前が空の場合にエラーとする
		if (userName.equals("")) {
			model.addAttribute("message", "名前を入力してください");

			return "order";
		}

		// メールアドレスが空の場合にエラーとする
		if (email.equals("")) {
			model.addAttribute("mailmessage", "メールアドレスを入力してください");

			return "order";
		}

		// 住所が空の場合にエラーとする
		if (address.equals("")) {
			model.addAttribute("addmessage", "住所を入力してください");

			return "order";
		}

		//		Login login = new Login(userName, email, address);
		//		model.addAttribute("login", login);
		//		loginRepository.save(login);

		return "thankyou";
	}

	@GetMapping("/thankyou")
	public String thankyou() {
		return "thankyou";
	}
}
