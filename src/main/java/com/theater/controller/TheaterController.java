package com.theater.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theater.dto.MovieDTO;
import com.theater.dto.TheaterDTO;
import com.theater.service.impl.TheaterServiceImpl;

@RestController
@RequestMapping("/theatre")
public class TheaterController {

	@Autowired
	TheaterServiceImpl theatreService;
	
	@PostMapping("/addmovietotheatre")
	public void addmovietoTheatre(@PathVariable("tId") Long theatreId, @PathVariable("mId") String movieId) {
		theatreService.addmovietoTheatre(theatreId, movieId);
	}
	
	@PutMapping("/removemovie")
	public void removemoviefromtheatre(@PathVariable("Id") Long tId, @PathVariable("mId") String movieId) {
		theatreService.removemovie(tId, movieId);
	}
	
	@GetMapping("/getmovies")
	public Set<MovieDTO> getmovies(@PathVariable("Id") Long tId) {
		return theatreService.getMovies(tId);
	}
	
	@GetMapping("/gettheater")
	public TheaterDTO gettheater(@PathVariable("Id") Long tId) {
		return theatreService.getTheater(tId);
	}
}
