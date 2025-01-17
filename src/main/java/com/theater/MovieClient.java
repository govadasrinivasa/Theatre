package com.theater;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.theater.dto.MovieDTO;

@FeignClient(name="movie", url="http://localhost:8093", path="/movie")
public interface MovieClient {

	@GetMapping("/selectmovie")
	public ResponseEntity<MovieDTO> selectmovie(@PathVariable("Id") String Id);
	
}
