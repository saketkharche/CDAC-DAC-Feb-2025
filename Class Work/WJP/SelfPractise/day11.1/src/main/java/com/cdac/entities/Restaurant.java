package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

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
	//Restaurant 1 -----> * FoodItem
	/*
	 * Always init the collection - to avoid NPExc
	 */
	@OneToMany(mappedBy="myRestaurant",
			cascade = CascadeType.ALL,orphanRemoval =true
	/* ,fetch=FetchType.EAGER */ )
	private List<FoodItem> foodItems=new ArrayList<>();
	public Restaurant(String name, String address, String city, String description) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
	}
	public void addFoodItem(FoodItem foodItem) {
		//establish bi dir association 
		this.foodItems.add(foodItem);//parent -> child
		foodItem.setMyRestaurant(this);//child -> parent		
	}
	
	public void removeFoodItem(FoodItem foodItem) {
		//un -establish bi dir association 
		this.foodItems.remove(foodItem);//parent ---X---> child 
		foodItem.setMyRestaurant(null);//child ---X---> parent
		
	}
	
	

}
