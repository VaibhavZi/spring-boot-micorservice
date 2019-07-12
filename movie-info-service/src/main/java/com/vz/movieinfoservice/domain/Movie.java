package com.vz.movieinfoservice.domain;

import java.io.Serializable;

public class Movie implements Serializable{
	private int movieId;
	private String movieName;
	
	
	public Movie(int movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}
