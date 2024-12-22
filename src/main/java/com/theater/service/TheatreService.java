package com.theater.service;

import java.util.Set;

import com.theater.dto.MovieDTO;
import com.theater.dto.TheaterDTO;

public interface TheatreService {

	void addmovietoTheatre(Long Id,String movieName);
	
	void removemovie(Long tId,String mId);
	
	Set<MovieDTO> getMovies(Long mId);
	
	TheaterDTO getTheater(Long tId);
}
