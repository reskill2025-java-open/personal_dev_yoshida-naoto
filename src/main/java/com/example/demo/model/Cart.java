package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Drink;

@Component
@SessionScope
public class Cart {

	private List<Drink> drinkList = new ArrayList<>();

	public List<Drink> getDrinkList() {
		return drinkList;
	}

	public int getTotalPrice() {

		int total = 0;
		for (Drink drink : drinkList) {
			total += drink.getPrice() * drink.getQuantity();
		}
		return total;
	}

	public void add(Drink newDrink) {

		Drink existsDrink = null;

		for (Drink drink : drinkList) {
			if (drink.getDrinkId() == newDrink.getDrinkId()) {
				existsDrink = drink;
				break;
			}
		}

		if (existsDrink == null) {
			drinkList.add(newDrink);
		} else {
			existsDrink.setQuantity(
					existsDrink.getQuantity() + newDrink.getQuantity());
		}
	}

	public void delete(int DrinkId) {
		for (Drink drink : drinkList) {
			if (drink.getDrinkId() == DrinkId) {
				drinkList.remove(drink);
				break;
			}
		}
	}

	public void clear() {
		drinkList = new ArrayList<>();

	}
}