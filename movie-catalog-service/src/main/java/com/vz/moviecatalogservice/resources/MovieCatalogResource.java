package com.vz.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.vz.moviecatalogservice.domain.CatalogItem;
import com.vz.moviecatalogservice.domain.Movie;
import com.vz.moviecatalogservice.domain.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		// get all the movies rated by user
		UserRatings ratings= restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRatings.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			// for each movie Id, call the movie info service and get the details of movie
			Movie movie =
					restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(),
					Movie.class);
			// Put them all together & return the List.
			return new CatalogItem(movie.getMovieName(), "Marvel Moview", rating.getRating());
		}).collect(Collectors.toList());
	}

}

/*
 * 			Movie movie = webClientBuilder.build().get().uri("http://localhost:8087/movie/" + rating.getMovieId())
					.retrieve().bodyToMono(Movie.class).block();
 * */