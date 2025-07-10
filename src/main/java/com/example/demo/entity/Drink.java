package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "drink")
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drink_id")
	private Integer drinkId;

	@Column(name = "drink_name")
	private String drinkName;

	private Integer price;

	@Column(name = "category_id")
	private Integer categoryId;

	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
	private Category category;

	private Integer amount;

	private String factory;

	@Transient
	private Integer quantity;

	public Integer getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(Integer drinkId) {
		this.drinkId = drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category.getCategory();
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
