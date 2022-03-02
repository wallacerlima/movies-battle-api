package com.letscode.moviesbattle.domain.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.letscode.moviesbattle.domain.model.Ranking;
import com.letscode.moviesbattle.domain.repository.RankingRepository;
import com.letscode.moviesbattle.fixtures.builders.match.MatchBuilder;
import com.letscode.moviesbattle.fixtures.builders.player.PlayerBuilder;
import com.letscode.moviesbattle.fixtures.builders.ranking.RankingBuilder;

@ExtendWith(MockitoExtension.class)
public class RankingServiceTest {
	
	@Mock
	private RankingRepository rankingRepository;
	
	@InjectMocks
	private RankingService rankingService;
	
	private String playerId = "e15b98b5-a84b-4b95-ab67-2cf1f9086348";
	
	@Test
	public void shouldReturnAGameRanking() {
		rankingService.getGameRanking();
		verify(rankingRepository, times(1)).findAllByOrderByTotalScoreDesc();
	}
	
	@Test
	public void givenAMatch_shouldUpdateRanking() {
		
		var player = PlayerBuilder.aPlayer().build();
		var match = MatchBuilder.aMatch().finished().withPlayer(player).build();
		var ranking = RankingBuilder.aRanking().build();
		
		when(rankingRepository.findByPlayerId(playerId)).thenReturn(Optional.of(ranking));
		
		rankingService.updateRankingPlayerBy(match);
		verify(rankingRepository, times(1)).save(any(Ranking.class));
	}

}
