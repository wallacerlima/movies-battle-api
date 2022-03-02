package com.letscode.moviesbattle.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.letscode.moviesbattle.fixtures.builders.movie.MovieBuilder;

public class MovieTest {
	@Test
	public void givenAMovie_shouldReturnMoviePoints() {
		var movie = MovieBuilder.aMovie().One().build();

		var moviePoints = movie.getMoviePoints();
		
		assertEquals(new BigDecimal(133.5), moviePoints);
	}
}
