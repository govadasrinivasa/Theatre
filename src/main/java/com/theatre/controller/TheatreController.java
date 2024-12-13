package com.theatre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theatre.dto.TheatreDTO;
import com.theatre.service.impl.TheatreServiceImpl;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

	@Autowired
	TheatreServiceImpl theatreService;
	
	@PostMapping("/addmovietotheatre")
	public void addmovietoTheatre(@PathVariable("Id") String Id, @PathVariable("moviename") String movieName) {
		theatreService.register(theatreDTO);
		System.out.println();
	}
	
	@GetMapping("login/{id}")
	public TheatreDTO removemoviefromtheatre(@PathVariable("username") String username, @PathVariable("password") String password) {
		//TicketBookingDTO ticketBookingDTO = ticketBookingService.getAccount(id);
		return null;
	}
}
