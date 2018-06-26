package com.thinkxfactor.zomatoplus.models;

import java.io.Serializable;

public class RestaurantItems implements Serializable {

	Restaurant restraunt;
	Items items;
	
	RestaurantItems() {}

	public RestaurantItems(Restaurant restraunt, Items items) {
		super();
		this.restraunt = restraunt;
		this.items = items;
	}

	public Restaurant getRestraunt() {
		return restraunt;
	}

	public void setRestraunt(Restaurant restraunt) {
		this.restraunt = restraunt;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	
	
}
