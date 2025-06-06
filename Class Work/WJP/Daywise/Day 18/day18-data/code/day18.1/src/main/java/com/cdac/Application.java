package com.cdac;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication 
// => it contains @Configuration -for declaring java config class
//can add @Bean methods - to declare 3rd party beans
public class Application {

   

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*
	 * add @Bean method to declare spring bean
	 *  - so that SC can manage its life cycle
	 *  - can be injected as dependency in other spring beans
	 */
	@Bean //singleton n eager spring bean
	 ModelMapper modelMapper() {
		System.out.println("creating model mapper");
		//later we will configure ModelMapper bean ....
		 ModelMapper mapper=new ModelMapper();
		/*
		 * to specify to ModelMapper - transfer only MATCHING 
		 * props from src->dest
		 */
		 mapper.getConfiguration()
		 .setMatchingStrategy(MatchingStrategies.STRICT)
		 /*
		  * to specify to ModelMapper -
		  * do not transfer nulls
		  */
		.setPropertyCondition(Conditions.isNotNull());
		 return mapper;
		 
	}

}
