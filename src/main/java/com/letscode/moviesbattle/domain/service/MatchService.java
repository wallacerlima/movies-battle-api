package com.letscode.moviesbattle.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.moviesbattle.domain.model.Match;
import com.letscode.moviesbattle.domain.model.Player;
import com.letscode.moviesbattle.domain.repository.MatchRepository;
import com.letscode.moviesbattle.domain.repository.PlayerRepository;

@Service
public class MatchService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	
	public Match startWith(String playerId) {
		var player = playerRepository.findById(playerId)
				.orElseThrow(() -> new RuntimeException("Player not found!"));
		
		validateAlreadyHaveAMatchInProgress(playerId);
		
		return createANewMatch(player);
	}
	

	private void validateAlreadyHaveAMatchInProgress(String playerId) {
		var match = matchRepository.findByPlayerIdAndFinishedAtIsNull(playerId);
		if(match.isPresent()) {
			throw new RuntimeException("The user already has a match in progress.");
		}
	}
	
	private Match createANewMatch(Player player) {
		var match = new Match();
		match.addPlayerToMatch(player);
		
		return matchRepository.save(match);
	}

}
