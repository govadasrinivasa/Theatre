package com.theater.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie implements Serializable {
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
	
	@Column(name="moviename", length=50)
	private String movieName;
	
	@Column(name="language", length=50)
	private String language;
	
	@Column(name="releasedate", length=50)
	private Date releaseDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Theater> theatres = new HashSet<>();

	public Set<Theater> getTheatres() {
		return theatres;
	}
	public void setTheatres(Set<Theater> theatres) {
		this.theatres = theatres;
	}
	
}
