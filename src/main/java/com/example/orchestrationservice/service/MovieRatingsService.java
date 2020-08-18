package com.example.orchestrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieRatingsService {
	
	
	@Autowired RestTemplate template;
	
	
	
	@HystrixCommand(fallbackMethod="getMovieRatingFallback")
	public String getMovieRating(String mid) {
		return template.getForObject("http://MOVIE-RATINGS-SERVICE/v1/ratings/"+mid, String.class);
	}
	

	public String getMovieRatingFallback(String mid) {
		return "MOVIE-RATINGS-SERVICE DONW "+mid;
		
	}
}
