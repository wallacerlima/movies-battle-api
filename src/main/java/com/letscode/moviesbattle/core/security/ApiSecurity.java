package com.letscode.moviesbattle.core.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.letscode.moviesbattle.domain.model.Player;
import com.letscode.moviesbattle.domain.repository.PlayerRepository;

@Component
public class ApiSecurity {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public String getPlayerId() {
		var authenticatedUser = (User) getAuthentication().getPrincipal();
		
		Optional<Player> player = 
				playerRepository.findByUsername(authenticatedUser.getUsername());
		
		return player.get().getId();
	}

}
