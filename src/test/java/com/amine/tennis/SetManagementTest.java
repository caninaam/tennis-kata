package com.amine.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.StatusGame;
import com.amine.tennis.enums.StatusSet;
import com.amine.tennis.utils.GameFinichedException;
import com.amine.tennis.utils.SetFinichedException;

import players.Player;

public class SetManagementTest {

	ISet garosSet;
	Logger logger = LoggerFactory.getLogger(SetManagementTest.class);

	Game garos;
	Player nadal = new Player("Nadal", 1);
	Player arazi = new Player("arazi", 1);

	@BeforeEach
	void setMockOutput() {
		garos = new Game();
		garosSet = new Set();

		garosSet.startSet(nadal, arazi);
		garos.start(nadal, arazi);

	}
	@Test
	void local_player_win_set()throws GameFinichedException, SetFinichedException {
		StatusSet status;
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		assertEquals(status, StatusSet.P1_WON);
		logger.info(garosSet.toString());
	
	}

	@Test
	void local_player_win_set_with_tie_break()throws GameFinichedException, SetFinichedException {
		StatusSet status;
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		
	//7 point for tie-break

		garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		assertEquals(StatusSet.P1_WON,status);
		logger.info(garosSet.toString());
	
	}
	@Test
	void local_player_win_set_with_tie_break_seven_seven()throws GameFinichedException, SetFinichedException {
		StatusSet status;
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerLocal(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		garos=new Game();
		garos.start(nadal, arazi);
		generateGameWinerVisitor(garos, nadal, arazi);
		status = garosSet.addGame(garos);
		
	//7 point for tie-break

		status=garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		
		status=garosSet.addPointForTieBreak(visitor_win_game());
		status=	garosSet.addPointForTieBreak(visitor_win_game());
		status=	garosSet.addPointForTieBreak(visitor_win_game());
		status=	garosSet.addPointForTieBreak(visitor_win_game());
		status=	garosSet.addPointForTieBreak(visitor_win_game());
		status=	garosSet.addPointForTieBreak(visitor_win_game());
		
		status=	garosSet.addPointForTieBreak(local_win_game());
		status=	garosSet.addPointForTieBreak(local_win_game());
		assertEquals(StatusSet.P1_WON,status);
		logger.info(garosSet.toString());
	
	}
	private  PlayerType local_win_game() {
		
		return  PlayerType.LOCAL;
	}
	private  PlayerType visitor_win_game() {
		
		return  PlayerType.VISITOR;
	}

	private void generateGameWinerLocal(Game game, Player p1, Player p2) throws GameFinichedException {
		if (game == null || game.gameFinished) {
			if( game.gameFinished)
			{
				logger.info(game.toString());
			}
			game = new Game();
			game.start(p1, p2);
		}
		StatusGame statut = game.winPoint(PlayerType.LOCAL );
		if (statut.equals(StatusGame.PLAYING))
			generateGameWinerLocal(game, p1, p2);

	}
	private void generateGameWinerVisitor(Game game, Player p1, Player p2) throws GameFinichedException {
		if (game == null || game.gameFinished) {
			if( game.gameFinished)
			{
				logger.info(game.toString());
			}
			
			game.start(p1, p2);
		}
		StatusGame statut = game.winPoint(PlayerType.VISITOR );
		if (statut.equals(StatusGame.PLAYING))
			generateGameWinerVisitor(game, p1, p2);

	}
	/**
	 * Test Player number 1 win.
	 * 
	 * @throws GameFinichedException
	 * @throws SetFinichedException
	 */

	void local_simple_win_test() throws GameFinichedException, SetFinichedException {
		StatusSet status;
		do {
			garos.start(nadal, arazi);
			generateRandomGame(garos, nadal, arazi);
			System.out.println(garos);
			status = garosSet.addGame(garos);
		} while (status.equals(StatusSet.PLAYING) && !((Set) garosSet).isTieBreak());
		// tie break
		do {
			status=garosSet.addPointForTieBreak(generateRandomPointForTie());
		} while (status.equals(StatusSet.PLAYING));
		System.out.println(garosSet);

	}

	private PlayerType generateRandomPointForTie() {
		Random r = new Random();
		return (r.nextBoolean() == true) ? PlayerType.LOCAL : PlayerType.VISITOR;
	}

	private void generateRandomGame(Game game, Player p1, Player p2) throws GameFinichedException {
		if (game == null) {
			game = new Game();
			game.start(p1, p2);
		}
		Random r = new Random();
		StatusGame statut = game.winPoint(r.nextBoolean() == true ? PlayerType.LOCAL : PlayerType.VISITOR);
		if (statut.equals(StatusGame.PLAYING))
			generateRandomGame(game, p1, p2);

	}
}