package com.org.movielibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.movielibrary.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "SELECT m FROM Movie m")
	List<Movie> findAllMovies(); 

}
