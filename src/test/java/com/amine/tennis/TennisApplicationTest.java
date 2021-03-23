package com.amine.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.StatusGame;
import com.amine.tennis.utils.GameFinichedException;

import players.Player;

public class TennisApplicationTest {

	IGame garos;

	@BeforeEach
	void setMockOutput() {
		garos = new Game();
		garos.start(new Player("Nadal", 1), new Player("arazi", 2));

	}

	/**
	 * Test Player number 1 win.
	 * 
	 * @throws GameFinichedException
	 */
	@Test
	void local_simple_win_test() throws GameFinichedException {

		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);

		assertEquals(garos.winPoint(PlayerType.LOCAL), StatusGame.P1_WON);
		System.out.println(" local_simple_win_test() ");
		System.out.println(garos);
	}

	/**
	 * Test Player number 2 win.
	 * 
	 * @throws GameFinichedException
	 */
	@Test
	void visitor_simple_win_test() throws GameFinichedException {
		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.LOCAL);

		assertEquals(garos.winPoint(PlayerType.VISITOR), StatusGame.P2_WON);
		System.out.println(" visitor_simple_win_test() ");
		System.out.println(garos);
	}

	/**
	 * Test Player number 2 win case of deuce.
	 * 
	 * @throws GameFinichedException
	 */
	@Test
	void visitor_win_case_deuce_test() throws GameFinichedException {
		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.VISITOR);
		garos.winPoint(PlayerType.VISITOR);

		assertEquals(garos.winPoint(PlayerType.VISITOR), StatusGame.P2_WON);
		System.out.println(" visitor_win_case_deuce_test() ");
		System.out.println(garos);
	}

	/**
	 * Test Erroe case game already finished
	 * 
	 * @throws GameFinichedException
	 */
	@Test
	void visitor_win_game_already_finished() throws GameFinichedException {
		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.VISITOR);

		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.VISITOR);
		garos.winPoint(PlayerType.VISITOR);
		garos.winPoint(PlayerType.VISITOR);
		assertThrows(GameFinichedException.class, () -> garos.winPoint(PlayerType.VISITOR));

	}
	@Test
	void local_simple_win_test2() throws GameFinichedException {

		garos.winPoint(PlayerType.VISITOR);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.LOCAL);
		garos.winPoint(PlayerType.VISITOR);
		garos.winPoint(PlayerType.VISITOR);
		garos.winPoint(PlayerType.LOCAL);;
		garos.winPoint(PlayerType.LOCAL);;
		System.out.println(" local_simple_win_test() ");
		System.out.println(garos);
	}
}
