package com.letscode.moviesbattle.core.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.letscode.moviesbattle.domain.model.Player;
import com.letscode.moviesbattle.domain.repository.PlayerRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Player> playerOptional = playerRepository.findByUsername(username);
		var player = playerOptional.orElseThrow(() -> new UsernameNotFoundException("User and/or password are incorrect"));
		
		return User.withUsername(player.getUsername())
				.password(player.getPassword())
				.authorities("USER_PLAYER")
				.build();
	}

}