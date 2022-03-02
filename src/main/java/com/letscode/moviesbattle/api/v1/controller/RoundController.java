package com.letscode.moviesbattle.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.moviesbattle.api.v1.assembler.RoundModelAssembler;
import com.letscode.moviesbattle.api.v1.assembler.RoundResultAnswerModelAssembler;
import com.letscode.moviesbattle.api.v1.model.RoundModel;
import com.letscode.moviesbattle.api.v1.model.RoundResultAnswerModel;
import com.letscode.moviesbattle.api.v1.model.input.RoundAnswerInput;
import com.letscode.moviesbattle.core.security.ApiSecurity;
import com.letscode.moviesbattle.domain.service.RoundService;

@RestController
@RequestMapping(value = "/v1/round", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoundController {

	@Autowired
	private ApiSecurity apiSecurity;
	
	@Autowired
	private RoundService roundService;
	
	@Autowired
	private RoundModelAssembler roundModelAssembler;
	
	@Autowired
	private RoundResultAnswerModelAssembler roundResultAnswerModelAssembler;
	
    @GetMapping
    public RoundModel getNextRound() {
		var nextRound = 
				roundService.getNextRound(apiSecurity.getPlayerId());
		
        return roundModelAssembler.toModel(nextRound);
    }
    
    @PostMapping("/answer")
    public RoundResultAnswerModel roundAnswer(@RequestBody @Valid RoundAnswerInput roundAnswerInput) {
    	
    	var round = roundService.saveRoundAnswer(roundAnswerInput.getMovieId(), apiSecurity.getPlayerId());

        return roundResultAnswerModelAssembler.toModel(round);
    }
	
}
