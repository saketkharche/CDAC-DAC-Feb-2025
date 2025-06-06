package com.cdac.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.AddRestaurantDTO;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.RestaurantMenuDTO;
import com.cdac.dto.RestaurantRespDTO;
import com.cdac.entities.Restaurant;

@Service
@Transactional // import from o.s
public class RestaurantServiceImpl implements RestaurantService {
	// depcy - dao layer i/f
	@Autowired
	private RestaurantDao restaurantDao;
	//depcy - ModelMapper for easy conversion
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RestaurantRespDTO> findAllAvailableRestaurants() {
		// convert List<Entity> -> List<DTO>
		return restaurantDao.findByStatusTrue() //List<Entity>
				.stream() //Stream<Entity>
				.map(entity -> modelMapper.map(entity, RestaurantRespDTO.class)) //Stream<DTO>
				.toList();
			//	.collect(Collectors.toList());
				
	}

	@Override
	public RestaurantRespDTO addRestaurant(AddRestaurantDTO dto) {
		// first validate if restaurant with the same name exists ?
		if (restaurantDao.existsByName(dto.getName()))
			throw new ApiException("Dup restaurant name !!!!!");
		//=> no dup found ! -> now convert (map) dto -> entity
		Restaurant entity = modelMapper.map(dto, Restaurant.class);
		// enable status - true
		entity.setStatus(true);
		// invoke dao's method
		Restaurant persistentEntity = restaurantDao.save(entity);
		// map entity -> resp dto
		return modelMapper.map(persistentEntity, RestaurantRespDTO.class);
	}

	@Override
	public List<Restaurant> findAllRestaurantsByKeyord(String keyword) {
		// TODO Auto-generated method stub
		return restaurantDao.findByDescriptionContaining(keyword);
	}

	@Override
	public String deleteDetails(Long restaurantId) {
		if (restaurantDao.existsById(restaurantId)) {
			restaurantDao.deleteById(restaurantId);
			return "Deleted restaurant details...";
		}
		throw new 
		ResourceNotFoundException("Invalid restaurant id - Deletion Failed!!!!!");
	}

	@Override
	public RestaurantRespDTO getRestaurantDetails(Long id) {
		// get details
		 Restaurant entity = restaurantDao.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException
				("Invalid restaurant id !!!!!"));
		 //convert(map) entity -> dto
		 return modelMapper.map(entity, RestaurantRespDTO.class);
	}

	@Override
	public ApiResponse updateDetails(Long restaurantId, 
			Restaurant restaurant) {
		//validate
		if(restaurantDao.existsById(restaurantId)) {
			Restaurant restaurant2 = restaurantDao.save(restaurant);
			return new ApiResponse("Updated restaurant details ....");
		}
		throw new ResourceNotFoundException
		("Invalid restaurant id !!!!!");
	}//DML - update

	@Override
	public RestaurantMenuDTO getRestaurantWithMenu(Long restaurantId) {
		//1. invoke dao's method 
		Restaurant entity=restaurantDao
				.fetchCompleteDetails(restaurantId)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Restaurant doesn't exitss by ID!!!!!"));
		//=> entity : persistent
		//2. Map entity -> dto
		return modelMapper.map(entity, RestaurantMenuDTO.class);
	}
	
	
	
	
	

}
