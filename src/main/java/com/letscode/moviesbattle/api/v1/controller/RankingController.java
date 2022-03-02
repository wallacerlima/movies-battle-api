package com.letscode.moviesbattle.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.moviesbattle.api.v1.assembler.RankingModelAssembler;
import com.letscode.moviesbattle.api.v1.model.RankingModel;
import com.letscode.moviesbattle.domain.service.RankingService;

@RestController
@RequestMapping(value = "/v1/ranking", produces = MediaType.APPLICATION_JSON_VALUE)
public class RankingController {
	
	@Autowired
	private RankingService rankingService;
	
	@Autowired
	private RankingModelAssembler rankingModelAssembler;
	
	@GetMapping
	public List<RankingModel> getGameRanking() {
		var ranking = rankingService.getGameRanking();
		return rankingModelAssembler.toCollectionModel(ranking);
	}

}
