package com.app.repo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.app.domain.Order;

@Repository
public class OrderRepo {

	public List<Order> buildOrder(){
		return Stream.of(
				new Order(1, "a"),
				new Order(2, "ab"),
				new Order(3, "abb")
				).collect(Collectors.toList());
				
				
	}
	
}
