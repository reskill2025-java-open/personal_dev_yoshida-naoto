package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {

	List<Drink> findByCategoryId(Integer categoryId);

	//	カテゴリー検索
	List<Drink> findByDrinkId(Integer drinkId);

	//	名前検索
	List<Drink> findByDrinkNameLike(String drinkName);

	//	～以下の値段検索
	List<Drink> findByPriceLessThanEqual(Integer price);

	//	カテゴリーと名前の同時検索
	List<Drink> findByCategoryIdAndDrinkNameLike(Integer CategoryId, String drinkName);

	//	カテゴリーと～以下の値段の同時検索
	List<Drink> findByCategoryIdAndPriceLessThanEqual(Integer CategoryId, Integer price);

	//	名前と～以下の値段の同時検索
	List<Drink> findByDrinkNameLikeAndPriceLessThanEqual(String drinkName, Integer price);

	//　全検索
	List<Drink> findByCategoryIdAndDrinkNameLikeAndPriceLessThanEqual(Integer CategoryId, String drinkName,
			Integer price);
}
