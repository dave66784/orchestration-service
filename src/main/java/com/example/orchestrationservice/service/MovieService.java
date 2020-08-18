package com.example.orchestrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieService {
	
	@Autowired RestTemplate template;

	@HystrixCommand(fallbackMethod="getMovieNameFallback")
	public String getMovieName(String mid) {
		return template.getForObject("http://MOVIE-SERVICE/v1/movie/"+mid, String.class);
	}
	
	
	public String getMovieNameFallback(String mid) {
		return "MOVIE-SERVICE DONW "+mid;
	}
	
	

}
