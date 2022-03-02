package com.letscode.moviesbattle.api.v1.assembler;

import org.springframework.stereotype.Component;

import com.letscode.moviesbattle.api.v1.model.RoundResultAnswerModel;
import com.letscode.moviesbattle.domain.model.Round;

@Component
public class RoundResultAnswerModelAssembler {
	
	public RoundResultAnswerModel toModel(Round round) {
		
		RoundResultAnswerModel resultRoundModel = new RoundResultAnswerModel();
		resultRoundModel.setRoundId(round.getId());
		resultRoundModel.setResult(round.getResult());
		resultRoundModel.setRemainingAttempts(round.getMatch().getRemainingAttempts());

		return resultRoundModel;
	}

}
