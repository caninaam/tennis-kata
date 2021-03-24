package com.amine.tennis;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.StatusSet;
import com.amine.tennis.utils.SetFinichedException;
import com.amine.tennis.utils.SetResultContainer;

import de.vandermeer.asciitable.AsciiTable;
import players.Player;

public class Set implements ISet {
	Logger logger = LoggerFactory.getLogger(Set.class);
	private PlayerType winner;
	private int scoreLocal = 0;
	private int scoreVisitor = 0;
	List<Game> gamesSet;
	boolean tieBreak = false;
	Player local;
	Player visitor;
	SetResultContainer result;
	SetResultContainer resultTie;

	int setNumber = 0;
	int localTieScore = 0;
	int visitorTieScore = 0;

	public Set() {
		gamesSet = new ArrayList<>();
		result = new SetResultContainer();
		setNumber = 0;
		localTieScore = 0;
		visitorTieScore = 0;
		resultTie = new SetResultContainer();

	}

	/**
	 * {@inheritdoc}
	 * 
	 */
	@Override
	public void startSet(Player p1, Player p2) {
		gamesSet.clear();
		this.local = p1;
		this.visitor = p2;
		setNumber = 0;
		localTieScore = 0;
		visitorTieScore = 0;
	}

	/**
	 * {@inheritdoc} .
	 */
	@Override
	public StatusSet addGame(Game game) throws SetFinichedException {
		if (winner == null && game.gameFinished) {
			gamesSet.add(game);
		} else
			throw new SetFinichedException("");

		return judge();
	}

	public StatusSet addPointForTieBreak(PlayerType WinnerOfTie) {
		if (WinnerOfTie.equals(PlayerType.LOCAL)) {
			localTieScore++;
		} else {
			visitorTieScore++;
		}
		return judge();

	}

	/**
	 * <p>
	 * methode that compute the score of set after each Game or tie break point.
	 * </p>
	 * @return StatusSet determine the winner or if the set is playin.
	 */
	private StatusSet judge() {
		// tie brek rule
		if (tieBreak) {
			resultTie.addSetResult(0, localTieScore + "", visitorTieScore + "");
			if (localTieScore > 6 && localTieScore - visitorTieScore >= 2) {
				return StatusSet.P1_WON;
			} else if (visitorTieScore > 6 && visitorTieScore - localTieScore >= 2) {
				return StatusSet.P1_WON;
			}

		} else {
			// update after the last game
			if (gamesSet.get(gamesSet.size() - 1).getWinner().equals(PlayerType.LOCAL)) {
				scoreLocal++;
			} else {
				scoreVisitor++;
			}
			;
			result.addSetResult(++setNumber, scoreLocal + "", scoreVisitor + "");
			if ((scoreLocal == 6 && scoreVisitor < 5) || (scoreLocal == 7 && !tieBreak)) {
				logger.info("Local wins");
				return StatusSet.P1_WON;
			}
			if ((scoreVisitor == 6 && scoreLocal < 5) || (scoreVisitor == 7 && !tieBreak)) {
				logger.info("Visitor wins");
				return StatusSet.P2_WON;
			}
			if (scoreLocal == 6 && scoreVisitor == 6) {
				tieBreak = true;
			}
		}
		return StatusSet.PLAYING;
	}
	/**
	 * <p>
	 * Draw a grid of result for log purpose.
	 * </p>
	 * @return  String.
	 */
	@Override
	public String toString() {
		AsciiTable at = new AsciiTable();

		at.addRule();
		at.addRow(result.getSetNumber());
		at.addRule();
		at.addRow(result.getP1result());
		at.addRule();
		at.addRow(result.getP2result());
		at.addRule();

		String rend = at.render();
		at = new AsciiTable();

		at.addRule();
		at.addRow(resultTie.getSetNumber());
		at.addRule();
		at.addRow(resultTie.getP1result());
		at.addRule();
		at.addRow(resultTie.getP2result());
		at.addRule();

		rend = System.lineSeparator() + rend + System.lineSeparator()
				+ ((isTieBreak()) ? "tie break" + at.render() : "");

		return rend;
	}

	public boolean isTieBreak() {
		return tieBreak;
	}

}
