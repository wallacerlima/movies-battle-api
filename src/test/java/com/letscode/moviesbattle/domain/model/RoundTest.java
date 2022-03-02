package com.letscode.moviesbattle.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.letscode.moviesbattle.fixtures.builders.match.MatchBuilder;
import com.letscode.moviesbattle.fixtures.builders.player.PlayerBuilder;
import com.letscode.moviesbattle.fixtures.builders.round.RoundBuilder;

public class RoundTest {
	
	@Test
	public void givenAnUnansweredRound_shouldFinishRoundWithCorrectAnswer() {
		var player = PlayerBuilder.aPlayer().build();
		var match = MatchBuilder.aMatch().withPlayer(player).build();
		var unansweredRound = RoundBuilder.aRound().withMatch(match).build();

		unansweredRound.finishRound(true);
		
		assertEquals(true, unansweredRound.getAnswered());
		assertEquals(RoundResult.CORRECT, unansweredRound.getResult());
	}
	
	@Test
	public void givenAnUnansweredRound_shouldFinishRoundWithWrongAnswer() {
		var player = PlayerBuilder.aPlayer().build();
		var match = MatchBuilder.aMatch().withPlayer(player).build();
		var unansweredRound = RoundBuilder.aRound().withMatch(match).build();

		unansweredRound.finishRound(false);
		
		assertEquals(true, unansweredRound.getAnswered());
		assertEquals(RoundResult.WRONG, unansweredRound.getResult());
		assertEquals(2, unansweredRound.getMatch().getRemainingAttempts());
	}
}
