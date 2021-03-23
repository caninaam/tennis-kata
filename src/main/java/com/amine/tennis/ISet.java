package com.amine.tennis;


import java.util.List;

import com.amine.tennis.enums.PlayerType;
import com.amine.tennis.enums.StatusSet;
import com.amine.tennis.utils.GameFinichedException;
import com.amine.tennis.utils.SetFinichedException;

import players.Player;

/**
 * @author ACANINA
 *
 */
public interface ISet {

	/**
	 * start the game.
	 * 
	 * @param p1
	 * @param p2
	 */
	public void startSet(Player p1, Player p2);
	/**
	 * add a game to the set for computing and identify the winner.
	 * s
	 * 
	 * @param game game.
	 * @return status of game if it's finish or not yet
	 * @throws SetFinichedException 
	 * @throws SetFinichedException If we try add point for finished Game.
	 */
	public StatusSet  addGame(Game game) throws SetFinichedException;
	
	/**
	 * add point when tie break.
	 * s
	 * 
	 * @param WinnerOfTie	WinnerOfTie.
	 * @return status of game if it's finish or not yet

	 */
	public StatusSet addPointForTieBreak(PlayerType WinnerOfTie);


}
