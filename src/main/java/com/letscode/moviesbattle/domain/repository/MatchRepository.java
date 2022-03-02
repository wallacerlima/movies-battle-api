package com.letscode.moviesbattle.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.moviesbattle.domain.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, String>{
	public Optional<Match> findByPlayerId(String playerId);
	public Optional<Match> findByPlayerIdAndFinishedAtIsNull(String playerId);
}
