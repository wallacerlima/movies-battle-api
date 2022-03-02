package com.letscode.moviesbattle.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscode.moviesbattle.domain.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
