package com.vz.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vz.movieinfoservice.domain.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfoResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") int movieId) {
		if(movieId==1) {
			return new Movie(movieId, "Avengers");
		}else if(movieId==2) {
			return new Movie(movieId, "Tranporters");
		}else
				return new Movie(movieId, "Fast Five");
	}

}
