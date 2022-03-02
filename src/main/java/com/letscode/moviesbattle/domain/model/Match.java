package com.letscode.moviesbattle.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Match {
	
	@EqualsAndHashCode.Include
	@Id
    @GenericGenerator(name = "matchId", strategy = "uuid2")
    @GeneratedValue(generator = "matchId")
	private String id;
	
    @ManyToOne
    @JoinColumn(name="player_id", referencedColumnName = "id")
    private Player player;
    
	@Column(name = "remaining_attempts")
	private Integer remainingAttempts = 3;

	@Column(name = "started_at", nullable = false, updatable = false)
	@CreationTimestamp
    private OffsetDateTime startedAt;
	
	@Column(name = "finished_at", nullable = true, updatable = true)
    private OffsetDateTime finishedAt;
	
	@Column(name = "score")
	private Long score = 0L;
	
	public void addPlayerToMatch(Player player) {
		this.player = player;
	}
}
