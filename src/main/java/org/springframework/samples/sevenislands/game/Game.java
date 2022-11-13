package org.springframework.samples.sevenislands.game;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.sevenislands.game.island.Island;
import org.springframework.samples.sevenislands.game.round.Round;
import org.springframework.samples.sevenislands.lobby.Lobby;
import org.springframework.samples.sevenislands.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "games")
public class Game extends BaseEntity {

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull
	private LocalDateTime creationDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDateTime endingDate;

	@OneToOne(mappedBy = "game")
	@NotNull
	private Lobby lobby;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.LAZY)
	private List<Round> rounds;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.LAZY)
	@Size(min = 7, max = 7)
	private List<Island> islands;
}
