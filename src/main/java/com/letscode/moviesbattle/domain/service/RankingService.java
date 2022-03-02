package com.letscode.moviesbattle.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.moviesbattle.domain.model.Match;
import com.letscode.moviesbattle.domain.model.Ranking;
import com.letscode.moviesbattle.domain.repository.RankingRepository;

@Service
public class RankingService {
	
	@Autowired
	private RankingRepository rankingRepository;
	
	public List<Ranking> getGameRanking() {
		return rankingRepository.findAllByOrderByTotalScoreDesc();
	}
	
	public void updateRankingPlayerBy(Match match) {
		var ranking = rankingRepository.findByPlayerId(match.getPlayer().getId())
				.orElse(new Ranking(match.getPlayer(), 0L));
		
		ranking.updateRanking(match);
		
		rankingRepository.save(ranking);
	}

}
