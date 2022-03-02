package com.letscode.moviesbattle.api.v1.assembler;

import org.springframework.stereotype.Component;

import com.letscode.moviesbattle.api.v1.model.MatchModel;
import com.letscode.moviesbattle.api.v1.model.PlayerModel;
import com.letscode.moviesbattle.domain.model.Match;

@Component
public class MatchModelAssembler {
	
	public MatchModel toModel(Match match) {
		
		PlayerModel playerModel = new PlayerModel();
		playerModel.setName(match.getPlayer().getName());
		playerModel.setUsername(match.getPlayer().getUsername());
		
		MatchModel matchModel = new MatchModel();
		matchModel.setMatchId(match.getId());
		matchModel.setPlayer(playerModel);
		matchModel.setScore(match.getScore());
		matchModel.setStartedAt(match.getStartedAt());
		
		return matchModel;
	}

}
