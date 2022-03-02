package com.letscode.moviesbattle.infrastructure.client.omdb.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OmdbMovieResponse {

	@JsonProperty("Title")
    private String title;
	
	@JsonProperty("Year")
    private Integer year;
	
	@JsonProperty("Genre")
    private String genre;
	
    private String imdbRating;
    
    private String imdbVotes;
}
