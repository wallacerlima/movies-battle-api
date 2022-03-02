package com.letscode.moviesbattle.api.v1.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.letscode.moviesbattle.api.v1.model.RankingModel;
import com.letscode.moviesbattle.domain.model.Ranking;

@Component
public class RankingModelAssembler {
	
	public List<RankingModel> toCollectionModel(List<Ranking> rankings) {
		
		List<RankingModel> rankingsModel = new ArrayList<>();
		
		for(int i = 0; i < rankings.size(); i++) {
			rankingsModel.add(toModel(i + 1, rankings.get(i)));
		}
			
		return rankingsModel;
	}
	
	private RankingModel toModel(Integer position, Ranking ranking) {
		
		RankingModel rankingModel = new RankingModel();
		rankingModel.setPosition(position);
		rankingModel.setUserName(ranking.getPlayer().getUsername());
		rankingModel.setName(ranking.getPlayer().getName());
		rankingModel.setTotalScore(ranking.getTotalScore());

		return rankingModel;
	}

}
