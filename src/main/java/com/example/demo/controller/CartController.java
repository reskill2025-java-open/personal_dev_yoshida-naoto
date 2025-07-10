package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Drink;
import com.example.demo.model.Cart;
import com.example.demo.repository.DrinkRepository;

@Controller
public class CartController {

	@Autowired
	Cart cart;

	@Autowired
	DrinkRepository drinkRepository;

	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(@RequestParam("drinkId") int drinkId) {

		Drink drink = drinkRepository.findById(drinkId).get();

		drink.setQuantity(1);

		cart.add(drink);

		return "redirect:/cart";
	}

	@PostMapping("/cart/delete")
	public String deleteCart(
			@RequestParam("drinkId") int drinkId) {

		cart.delete(drinkId);

		return "redirect:/cart";
	}

	@GetMapping("/drink/{detail}")
	public String cartDetail(@PathVariable("detail") Integer drinkId, Model model) {
		int a = 1;
		model.addAttribute("a", a);

		List<Drink> drinkList = drinkRepository.findByDrinkId(drinkId);
		model.addAttribute("drinkList", drinkList);

		return "/drink";
	}
}
