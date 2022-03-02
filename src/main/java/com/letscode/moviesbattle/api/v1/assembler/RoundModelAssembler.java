package com.letscode.moviesbattle.api.v1.assembler;

import org.springframework.stereotype.Component;

import com.letscode.moviesbattle.api.v1.model.MovieModel;
import com.letscode.moviesbattle.api.v1.model.RoundModel;
import com.letscode.moviesbattle.domain.model.Round;

@Component
public class RoundModelAssembler {
	
	public RoundModel toModel(Round round) {
		
		MovieModel firstMovieModel = new MovieModel();
		firstMovieModel.setMovieId(round.getFirstMovie().getId());
		firstMovieModel.setTitle(round.getFirstMovie().getTitle());
		firstMovieModel.setYear(round.getFirstMovie().getYear());
		firstMovieModel.setGenre(round.getFirstMovie().getGenre());
		
		MovieModel secondMovieModel = new MovieModel();
		secondMovieModel.setMovieId(round.getSecondMovie().getId());
		secondMovieModel.setTitle(round.getSecondMovie().getTitle());
		secondMovieModel.setYear(round.getSecondMovie().getYear());
		secondMovieModel.setGenre(round.getSecondMovie().getGenre());
		
		RoundModel roundModel = new RoundModel();
		roundModel.setRoundId(round.getId());
		roundModel.setFirstMovie(firstMovieModel);
		roundModel.setSecondMovie(secondMovieModel);
		
		return roundModel;
	}

}
