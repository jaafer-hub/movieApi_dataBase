package com.org.movielibrary.service;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.org.movielibrary.dao.MovieRepository;
import com.org.movielibrary.model.Movie;

@Service
public class MovieService {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

	
	@Autowired
	private MovieRepository movieRepository;
		
	public List<Movie>  getAllMovies() throws IOException {
		
		logger.info("fetching All Movies !!");
		
		List<Movie> data = movieRepository.findAll();
		
		return data;	
		
	}
	
	public Movie getMovie(Long id ) throws IOException {
		
		return this.findById(id);		
	}
	
	public void deleteMovie(Long id ) throws IOException {
		
		movieRepository.deleteById(id);
		logger.info("movie was deleted !");
	};
	
	
	   public Movie updateMovie( Long id , Movie movie) throws IOException, ParseException {
					
			Movie searchedMovie = this.findById(id);
			
			searchedMovie.setTitle(movie.getTitle());
			searchedMovie.setDirector(movie.getDirector());
			searchedMovie.setReleaseDate(movie.getReleaseDate());
			searchedMovie.setType(movie.getType());
			
			Movie updatedMovie = movieRepository.save(searchedMovie);
			
			logger.info(movie.getTitle()+" movie is updated !!");
			
			return updatedMovie;
			
		}
	   
	  public  List<Movie> searchMovie( Movie movie) throws IOException {		
			/*
			 * Gson gson = new GsonBuilder().create(); File resource = new
			 * ClassPathResource( this.fileName).getFile();
			 */
			List<Movie> data = movieRepository.findAll();		
			List<Movie> dataNew = new ArrayList<Movie>();
			for(Movie m : data)
			{
				if(m.equals(movie))
				{
					dataNew.add(m);
				}
			}
			return dataNew;
			
		}
	  
	  public Movie newMovie( Movie movie) throws IOException {
			
			return movieRepository.save(movie);
			
		}
	  
		public Movie findById(Long id) {
			Optional<Movie> result = movieRepository.findById(id);
			Movie post = null;
			
			if(result.isPresent()) {
				 post = result.get();
			}
			else {
				throw new RuntimeException("cannot find the post" + id);
			}
			return post;
		}

}
