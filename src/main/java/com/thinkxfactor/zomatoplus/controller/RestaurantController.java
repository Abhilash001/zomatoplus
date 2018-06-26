package com.thinkxfactor.zomatoplus.controller;


import java.io.IOException;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thinkxfactor.zomatoplus.models.*;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	List<Restaurant> restaurants = new ArrayList<>();
	
	@PostMapping("/create")
	public Restaurant restaurantCreate(@RequestBody Restaurant restaurant) {
		System.out.println(restaurant.toString());
		restaurants.add(restaurant);
		return restaurant;
	}
	
	@GetMapping("/getall")
	public List<Restaurant> restaurantList() {
		return restaurants;
	}
	
	@PostMapping("/additems")
	public Items restaurantAdd(@RequestBody RestaurantItems ri) {
		Restaurant restaurant = ri.getRestraunt();
		Items item = ri.getItems();
		System.out.println(restaurant.toString());
		System.out.println(item.toString());
		if(!restaurants.contains(restaurant)) restaurants.add(restaurant);
		else restaurant = restaurants.get(restaurants.indexOf(restaurant));
		List<Items> items = restaurant.getItems();
		items.add(item);
		restaurant.setItems(items);
		return item;
	}

	
}
