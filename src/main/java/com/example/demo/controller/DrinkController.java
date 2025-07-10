package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Drink;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.DrinkRepository;

@Controller
public class DrinkController {

	@Autowired
	DrinkRepository drinkRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/drink")
	public String drink(
			@RequestParam(name = "drinkId", defaultValue = "") Integer drinkId,
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "drinkName", defaultValue = "") String drinkName,
			@RequestParam(name = "price", defaultValue = "0") Integer price,
			Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);

		List<Drink> drinkList = null;

		if (categoryId == null || categoryId == 1) {

			if (drinkId == null) {
				if (drinkName.equals("")) {
					if (price == 0) {
						//	無記入　×××
						drinkList = drinkRepository.findAll();
					} else {
						//××〇
						drinkList = drinkRepository.findByPriceLessThanEqual(price);
					}
				} else {
					//×〇
					drinkName = "%" + drinkName + "%";
					drinkList = drinkRepository.findByDrinkNameLike(drinkName);
					//×〇×
					if (price == 0) {
						drinkList = drinkRepository.findByDrinkNameLike(drinkName);
						//×〇〇
					} else {
						drinkList = drinkRepository.findByDrinkNameLikeAndPriceLessThanEqual(drinkName, price);

					}
				}
			} else {
				drinkList = drinkRepository.findByDrinkId(drinkId);
			}
		} else {
			//〇×
			drinkList = drinkRepository.findByCategoryId(categoryId);
			if (drinkName.equals("")) {
				if (price == 0) {
					//	無記入　〇××
					drinkList = drinkRepository.findByCategoryId(categoryId);
				} else {
					//〇×〇
					drinkList = drinkRepository.findByCategoryIdAndPriceLessThanEqual(categoryId, price);
				}
			} else {
				//〇〇
				drinkName = "%" + drinkName + "%";
				drinkList = drinkRepository.findByCategoryIdAndDrinkNameLike(categoryId, drinkName);
				//〇〇×
				if (price == 0) {

					drinkList = drinkRepository.findByCategoryIdAndDrinkNameLike(categoryId, drinkName);
					//〇〇〇
				} else {
					drinkList = drinkRepository.findByCategoryIdAndDrinkNameLikeAndPriceLessThanEqual(categoryId,
							drinkName, price);
				}
			}
		}
		drinkName = drinkName.replaceAll("%", "");
		if (price == 0) {
			price = null;
		}
		model.addAttribute("drinkList", drinkList);
		model.addAttribute("drinkId", drinkId);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("drinkName", drinkName);
		model.addAttribute("price", price);

		return "drink";
	}

	@PostMapping("/drink")
	public String drinkCategory(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);

		List<Drink> drinkList = null;
		if (categoryId == null || categoryId == 1) {

			drinkList = drinkRepository.findAll();
		} else {
			drinkList = drinkRepository.findByCategoryId(categoryId);
		}
		model.addAttribute("drinkList", drinkList);
		return "drink";

	}
}
