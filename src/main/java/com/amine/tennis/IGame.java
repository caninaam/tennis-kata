package com.amine.tennis;

import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.StatusGame;
import com.amine.tennis.utils.GameFinichedException;

import players.Player;

/**
 * @author ACANINA
 *
 */
public interface IGame {

	/**
	 * start the game.
	 * 
	 * @param p1
	 * @param p2
	 */
	public void start(Player p1, Player p2);

	/**
	 * 
	 * @param player hwo is the winer of point.
	 * @return status of game if it's finish or not yet
	 * @throws GameFinichedException If we try add point for finished Game.
	 */
	public StatusGame winPoint(PlayerType player) throws GameFinichedException;

}
