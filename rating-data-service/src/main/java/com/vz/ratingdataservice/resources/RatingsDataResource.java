package com.vz.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vz.ratingdataservice.domain.Rating;
import com.vz.ratingdataservice.domain.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

	@RequestMapping("/{movieId}")
	public Rating getRatingsData(@PathVariable("movieId") int movieId) {
		return new Rating(movieId, 5);
	}

	@RequestMapping("/users/{userId}")
	public UserRatings getUserRatingsData(@PathVariable("userId") int userId) {
		List<Rating> ratings = Arrays.asList(new Rating(1, 5), 
											 new Rating(2, 4));
		UserRatings  userRatings = new UserRatings();
		userRatings.setUserRating(ratings);
		return userRatings;
	}

}
