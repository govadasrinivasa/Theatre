package com.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theater.entity.Theater;

public interface TheatreRepository extends JpaRepository<Theater, Long> {

}
