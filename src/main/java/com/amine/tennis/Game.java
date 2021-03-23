package com.amine.tennis;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amine.tennis.enums.DeuceStateMachine;
import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.ScoreEnumMap;
import com.amine.tennis.enums.StatusGame;
import com.amine.tennis.utils.GameFinichedException;
import com.amine.tennis.utils.GameResultContainer;

import de.vandermeer.asciitable.AsciiTable;
import players.Player;

/**
 * @author ACANINA
 *
 */
/**
 * @author ACANINA
 *
 */
public class Game implements IGame {

	Logger logger = LoggerFactory.getLogger(Game.class);

	Player local;
	Player visitor;
	boolean isDeuce = false;
	int gameNumber;
	boolean gameFinished = false;
	GameResultContainer result;
	

    /**
     * Return the winner
     */
	private PlayerType winner;

	public PlayerType getWinner() {
		return winner;
	}

	@Override
	public void start(Player p1, Player p2) {
		this.local = p1;
		this.visitor = p2;
		local.setScore(0);
		visitor.setScore(0);
		gameNumber = 0;
		result = new GameResultContainer();
		gameFinished=false;
		isDeuce=false;
		winner=null;
		p1.setStateDeuce(DeuceStateMachine.EQUALITY);
		p2.setStateDeuce(DeuceStateMachine.EQUALITY);
	}

	@Override
	public StatusGame winPoint(PlayerType player) throws GameFinichedException {
		if (gameFinished)
			throw new GameFinichedException("Game already over");
		boolean localWinsPoint = player == PlayerType.LOCAL;
	
		if (((local.getScore() == 3 && visitor.getScore() == 3))) {
			isDeuce = true;

		}
		if (localWinsPoint) {
			local.winPoint(isDeuce);
			visitor.losePoint(isDeuce);
		} else {
			visitor.winPoint(isDeuce);
			local.losePoint(isDeuce);
		}

		if (!isDeuce) {
			logger.info("score p1 " + local.getName() + " : " + ScoreEnumMap.get(local.getScore()) + "---"
					+ ScoreEnumMap.get(visitor.getScore()) + " plalyer 2 " + visitor.getName());
			result.addGameResult(++gameNumber, ScoreEnumMap.get(local.getScore()).toString(),
					ScoreEnumMap.get(visitor.getScore()).toString());
		

		} else {

			logger.info("score p1 " + local.getName() + " : " + local.getStateDeuce() + "---" + visitor.getStateDeuce()
					+ " plalyer 2 " + visitor.getName());
			result.addGameResult(
					local.getStateDeuce().toString() != "LOST" || visitor.getStateDeuce().toString() != "WIN"
							? ++gameNumber
							: 0,
					local.getStateDeuce().toString(), visitor.getStateDeuce().toString());

		}

		if (!isDeuce) {
			if ((local.getScore() == 4) || (visitor.getScore() == 4)) {
				result.addGameResult(0,(local.getScore() == 4)?DeuceStateMachine.WIN.toString():DeuceStateMachine.LOST.toString() ,
						(visitor.getScore() == 4)?DeuceStateMachine.WIN.toString():DeuceStateMachine.LOST.toString());
			
				gameFinished = true;
				if (local.getScore() == 4) {
					winner=PlayerType.LOCAL;
					return StatusGame.P1_WON;
				}
				if (visitor.getScore() == 4) {
					winner=PlayerType.VISITOR;
					return StatusGame.P2_WON;
				}
			}
		} else {

			if (local.getStateDeuce() == DeuceStateMachine.WIN) {
				winner=PlayerType.LOCAL;
				gameFinished = true;
				return StatusGame.P1_WON;
			} else if (visitor.getStateDeuce() == DeuceStateMachine.WIN) {
				winner=PlayerType.VISITOR;
				gameFinished = true;
				return StatusGame.P2_WON;
			}
		}
		return StatusGame.PLAYING;
	}

	@Override
	public String toString() {
		AsciiTable at = new AsciiTable();

		at.addRule();
		at.addRow(result.getGameNumber());
		at.addRule();
		at.addRow(result.getP1result());
		at.addRule();
		at.addRow(result.getP2result());
		at.addRule();

		String rend = at.render();

		return System.lineSeparator()+rend;
	}

	public static void main(String[] rr) {
		System.out.println(new Game());
	}

}
