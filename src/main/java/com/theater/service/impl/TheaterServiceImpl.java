package com.theater.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.theater.MovieClient;
import com.theater.dto.MovieDTO;
import com.theater.dto.TheaterDTO;
import com.theater.entity.Movie;
import com.theater.entity.Screen;
import com.theater.entity.Theater;
import com.theater.repository.TheatreRepository;
import com.theater.service.TheatreService;

@Service
public class TheaterServiceImpl implements TheatreService {

	private final TheatreRepository theatreRepo;
    private ModelMapper mapper;
	
	@Autowired(required = true)
	private MovieClient movieClient;
	
	public TheaterServiceImpl(TheatreRepository theatreRepo, ModelMapper mapper) {
		this.theatreRepo = theatreRepo;
		this.mapper = mapper;
	}

	@Override
	public void addmovietoTheatre(Long tId,String mId) {
		ResponseEntity<MovieDTO> movieDTO = null;
		Screen screen = new Screen();
		if(!tId.equals("") && !mId.equals("")) {
			movieDTO = movieClient.selectmovie(mId);
			String newMovie = movieDTO.getBody().getMovieName();
			Theater theatre = theatreRepo.findById(tId).get();
			theatre.getScreen().stream().forEach(s -> {
				Movie movie = screen.getMovie();
				String moviename = movie.getMovieName();
				if(moviename.equals("")) {
					movie.setMovieName(moviename);
					screen.setMovie(movie);
				}
				});
			theatre.setCity("");
			theatre.setAddress("");
			theatreRepo.save(theatre);
		}
	}

	@Override
	public void removemovie(Long tId, String mId) {
		ResponseEntity<MovieDTO> movieDTO = null;
		Screen screen = new Screen();
		if(!tId.equals("") && !mId.equals("")) {
			movieDTO = movieClient.selectmovie(mId);
			Theater theatre = theatreRepo.findById(tId).get();
			theatre.getScreen().stream().forEach(s -> {
				String movie = screen.getMovie().getMovieName();
				if(movie.equals("mId")) {
					screen.setMovie(null);
				}
				});
			theatreRepo.save(theatre);
		}
	}

	@Override
	public Set<MovieDTO> getMovies(Long tId) {
		Set<MovieDTO> movies = new HashSet<>();
		Theater theatre = theatreRepo.findById(tId).get();
		theatre.getScreen().stream().forEach(s -> {
			Movie movie = s.getMovie();
			MovieDTO movieDTO = mapper.map(movie, MovieDTO.class);
			movies.add(movieDTO);
			});
		return movies;
	}
	
	@Override
	public TheaterDTO getTheater(Long tId) {
		Set<MovieDTO> movies = new HashSet<>();
		Theater theatre = theatreRepo.findById(tId).get();
		TheaterDTO theaterDTO = mapper.map(theatre, TheaterDTO.class);
		return theaterDTO;
	}

}
