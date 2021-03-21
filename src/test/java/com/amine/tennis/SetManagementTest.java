package com.amine.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.StatusGame;
import com.amine.tennis.utils.GameFinichedException;

import players.Player;

public class SetManagementTest {

	ISet garosSet;

	IGame garos;
	@BeforeEach
	void setMockOutput() {
		garosSet = new Set();
		garosSet.startSet(new Player("Nadal", 1), new Player("arazi", 2));

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
}