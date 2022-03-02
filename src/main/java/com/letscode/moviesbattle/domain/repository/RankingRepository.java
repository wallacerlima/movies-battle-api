package com.letscode.moviesbattle.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.moviesbattle.domain.model.Ranking;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, String>{
	public List<Ranking> findAllByOrderByTotalScoreDesc();
	public Optional<Ranking> findByPlayerId(String playerId);
}
