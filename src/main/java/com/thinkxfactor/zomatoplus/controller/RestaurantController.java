package com.thinkxfactor.zomatoplus.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinkxfactor.zomatoplus.models.*;
import com.thinkxfactor.zomatoplus.repository.ItemsRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@PostMapping("/create")
	public Restaurant restaurantCreate(@RequestBody Restaurant restaurant) {
		Restaurant res = restaurantRepository.save(restaurant);
		return res;
	}
	
	@GetMapping("/getAll")
	public List<Restaurant> restaurantList() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants;
	}
	
	@PostMapping("/addItems")
	public Items restaurantAdd(@RequestBody Items item) {
		Items it = itemsRepository.save(item);
		return it;
	}
	
}
