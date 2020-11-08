package com.app;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.domain.Order;
import com.app.repo.OrderRepo;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringCloudAwsLamdaApplication {

	
	@Autowired
	private OrderRepo orderreop;
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAwsLamdaApplication.class, args);
	}
	
	//endpoint
	@Bean
	public Supplier<List<Order>> getAllOrder(){
		return ()->orderreop.buildOrder();
	}
	
	@Bean
	  public Function<Flux<String>, Flux<String>> uppercase() {
	    return flux -> flux.map(value -> value.toUpperCase());
	  }

	@Bean
	public Function<String, String> reverse(){
		return (input)->new StringBuilder(input).reverse().toString();
	}
	@Bean
	public Predicate<String> getStatus(){
		return (input)->input.equals("Brajesh");
	}
	@Bean 
	public Consumer<String> setString(){
		return (input)->System.out.print(input);

	}
	
	
}
