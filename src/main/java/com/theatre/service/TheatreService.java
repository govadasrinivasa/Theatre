package com.theatre.service;

import com.theatre.dto.TheatreDTO;

public interface TheatreService {

	void addmovietoTheatre(String Id,String movieName);
	TheatreDTO updateAccount(TheatreDTO theatreDTO);
}
