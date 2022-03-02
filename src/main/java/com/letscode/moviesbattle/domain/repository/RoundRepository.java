package com.letscode.moviesbattle.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.moviesbattle.domain.model.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, String>{
	
	public Optional<Round> findByAnsweredFalseAndMatchId(String matchId);
	
	public Optional<Round> findByMatchIdAndFirstMovieIdAndSecondMovieId(String matchId, String firstMovieId, String secondMovieId);

}
