package com.letscode.moviesbattle.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.moviesbattle.domain.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
	public Optional<Player> findByUsername(String username);
}
