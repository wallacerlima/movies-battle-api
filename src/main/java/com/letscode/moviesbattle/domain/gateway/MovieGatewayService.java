package com.letscode.moviesbattle.domain.gateway;

import java.util.List;

import com.letscode.moviesbattle.domain.model.Movie;

public interface MovieGatewayService {

	public List<Movie> getTop50Movies();
}
