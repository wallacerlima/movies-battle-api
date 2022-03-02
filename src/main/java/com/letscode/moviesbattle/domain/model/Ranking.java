package com.letscode.moviesbattle.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Ranking {
	@EqualsAndHashCode.Include
	@Id
    @GenericGenerator(name = "rankingId", strategy = "uuid2")
    @GeneratedValue(generator = "rankingId")
	private String id;
	
    @ManyToOne
    @JoinColumn(name="player_id", referencedColumnName = "id")
    private Player player;
    
	@Column(name = "total_score")
	private Long totalScore;
}
