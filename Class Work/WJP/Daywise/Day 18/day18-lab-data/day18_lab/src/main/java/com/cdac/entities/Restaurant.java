package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="restaurants")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = "foodItems")

public class Restaurant extends BaseEntity {
	@Column(length = 100,unique = true)
	private String name;
	private String address;
	@Column(length = 20)
	private String city;
	private String description;	
	//one - many bi dir association , Restaurant 1<---->* FoodItem
	//one , parent table , inverse
	@OneToMany(mappedBy = "myRestaurant",
			cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	//@JsonIgnore
	private List<FoodItem> foodItems=new ArrayList<>();
	
	//to support soft delete op - add status flag
	private boolean status;
	public Restaurant(String name, String address, String city, String description) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
	}
	//add helper methods - to add/remove food item 
	public void addFoodItem(FoodItem foodItem)
	{
		this.foodItems.add(foodItem);//restaurant -> food item
		foodItem.setMyRestaurant(this);//food item -> restaurant
	}
	public void removeFoodItem(FoodItem foodItem)
	{
		this.foodItems.remove(foodItem);
		foodItem.setMyRestaurant(null);
	}
	
	

}
