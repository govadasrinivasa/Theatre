package com.theatre;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.theatre.dto.MovieDTO;

@FeignClient(name="movie", url="http://localhost:8093", path="/movie")
public interface MovieClient {

	@GetMapping("/selectmovie")
	public MovieDTO selectmovie(@PathVariable("Id") String Id, @PathVariable("moviename") String movieName);
	
}
