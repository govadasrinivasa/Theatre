package com.theater;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.theater.dto.UserManagementDTO;

@FeignClient(name="usermanagement", url="http://localhost:8091", path="/um")
public interface UserManagementClient {

	@GetMapping("{id}")
	public ResponseEntity<UserManagementDTO> getUser(@PathVariable(name = "id") long id);
}
