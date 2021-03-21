package com.amine.tennis;

import java.util.ArrayList;
import java.util.List;

import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.StatusSet;
import com.amine.tennis.utils.SetFinichedException;

import players.Player;

public class Set implements ISet {

	private PlayerType winner;
	private int scoreLocal = 0;
	private int scoreVisitor = 0;
	List<Game> gamesSet;
	boolean tieBreak=false;
	Player local;
	Player visitor;

	public Set() {
		gamesSet = new ArrayList<>();
		
	}

	@Override
	public void startSet(Player p1, Player p2) {
		gamesSet.clear();
		this.local = p1;
		this.visitor = p2;
	}

	@Override
	public StatusSet addGame(Game game) throws SetFinichedException {
		if (winner == null && game.gameFinished) {
			gamesSet.add(game);
		} else
			throw new SetFinichedException("");

		return judge();
	}

	public StatusSet judge() {

		gamesSet.forEach((Game g) -> {
			if (g.getWinner().equals(PlayerType.LOCAL)) {
				scoreLocal++;
			} else {
				scoreVisitor++;
			}
		});
		if ((scoreLocal == 6 && scoreVisitor < 4) || (scoreLocal == 7&& !tieBreak)) {
			return StatusSet.P1_WON;
		}
		if ((scoreVisitor == 6 && scoreLocal < 4) || (scoreVisitor == 7 && !tieBreak)) {
			return StatusSet.P2_WON;
		}
		if(scoreLocal==6 && scoreVisitor==6)
		{
			tieBreak=true;
		}
		return StatusSet.PLAYING;
	}
}
