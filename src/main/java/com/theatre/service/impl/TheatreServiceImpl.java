package com.theatre.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.theatre.MovieClient;
import com.theatre.dto.MovieDTO;
import com.theatre.dto.TheatreDTO;
import com.theatre.repository.TheatreRepository;
import com.theatre.service.TheatreService;
import com.transaction.dto.BankAccountDTO;

@Service
public class TheatreServiceImpl implements TheatreService {

	private final TheatreRepository theatreRepo;
    private ModelMapper mapper;
	
	@Autowired(required = true)
	private MovieClient movieClient;
	
	public TheatreServiceImpl(TheatreRepository theatreRepo, ModelMapper mapper) {
		this.theatreRepo = theatreRepo;
		this.mapper = mapper;
	}

	@Override
	public void addmovietoTheatre(String Id,String movieName) {
		MovieDTO movieDTO = null;
		if(!Id.equals("") && !movieName.equals("")) {
			ResponseEntity<MovieDTO> movieDTO = movieClient.selectmovie(Id, movieName);
			Movie movie = movieRepo.findMovieByMoviename(Long.getLong(Id), movieName);
			movieDTO = mapper.map(movie, MovieDTO.class);
		}
		return movieDTO;
	}

	@Override
	public TheatreDTO updateAccount(TheatreDTO theatreDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
