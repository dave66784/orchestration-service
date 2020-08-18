package com.example.orchestrationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.orchestrationservice.models.Movie;
import com.example.orchestrationservice.service.MovieRatingsService;
import com.example.orchestrationservice.service.MovieService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RequestMapping("/v1/orcas")
@RestController
public class OrchestrationController {
	
	@Autowired MovieService movieservice;
	
	@Autowired MovieRatingsService movieratingsservice;
	
	
	@GetMapping("/{mid}")
	public Movie getMovie(@PathVariable("mid") String mid) {
		
		
		Movie movie = new Movie(movieservice.getMovieName(mid),movieratingsservice.getMovieRating(mid));
		
		
		return movie;
	}



}
