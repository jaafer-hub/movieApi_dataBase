package com.org.movielibrary.controller;



import java.io.IOException;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.movielibrary.model.Movie;
import com.org.movielibrary.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
    private MovieService movieService;
	
	@PostMapping("/movie/add")
    Movie newMovie( @RequestBody Movie movie) throws IOException {
		
		
		return movieService.newMovie(movie);
		
	}
	
	@PostMapping("/movie/search")
	List<Movie> searchMovie( @RequestBody Movie movie) throws IOException {		
		
		return movieService.searchMovie(movie);
		
	}
	
	@RequestMapping(value = "/movie/update/{id}", method = RequestMethod.POST)
    Movie updateMovie(@PathVariable("id")  Long id , @RequestBody Movie movie) throws IOException, ParseException {
		return movieService.updateMovie(id, movie);
		
	}
	
	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET)
	void deleteMovie(@PathVariable("id")  Long id ) throws IOException {		
		movieService.deleteMovie(id);
	}
	
	@RequestMapping(value = "/movie/get/{id}", method = RequestMethod.GET)
	Movie getMovie(@PathVariable("id") Long id ) throws IOException {		
		return movieService.getMovie(id);		
	}
	
	@GetMapping("/movie/list")
	List<Movie> all() throws IOException {		
		return movieService.getAllMovies();
	}

}
