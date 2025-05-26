package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="restaurants")
@NoArgsConstructor
@AllArgsConstructor
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
	@OneToMany
	private List<FoodItem> foodItems=new ArrayList<>();
	

}
