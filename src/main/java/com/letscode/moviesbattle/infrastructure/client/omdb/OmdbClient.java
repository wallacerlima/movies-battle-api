package com.letscode.moviesbattle.infrastructure.client.omdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.letscode.moviesbattle.core.properties.OmdbProperties;
import com.letscode.moviesbattle.infrastructure.client.omdb.response.OmdbMovieResponse;

@Component
public class OmdbClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OmdbProperties omdbProperties;
	
	public OmdbMovieResponse getMovieBy(String title) {
		
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(omdbProperties.getHost())
		        .queryParam("apikey", omdbProperties.getKey())
		        .queryParam("t", title)
		        .build()
		        .toUriString();
		        
		return restTemplate.exchange(
				urlTemplate, 
				HttpMethod.GET,
				null,
				OmdbMovieResponse.class
				).getBody();
	}
}
