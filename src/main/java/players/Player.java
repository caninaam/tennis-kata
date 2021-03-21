package players;

import com.amine.tennis.enums.DeuceStateMachine;

public class Player {
	private String name;
	private int rank;
	private int score = 0;
	private DeuceStateMachine stateDeuce = DeuceStateMachine.EQUALITY;

	public Player(String name, int rank) {
		super();
		this.name = name;
		this.rank = rank;
	}
	/**  Player  win.
	 * @param deuce if mode deuce is active.
	 */
	public void winPoint(boolean deuce) {
		if (score < 4 && !deuce)
			score++;
		if(!deuce&& score==4)
			stateDeuce = stateDeuce.winPoint();
		if (deuce) {
			stateDeuce = stateDeuce.winPoint();
		}
	}
	/**  Player  lose.
	 * @param deuce if mode deuce is active.
	 */
	public void losePoint(boolean deuce) {
		if (deuce) {
			stateDeuce = stateDeuce.losePoint();
		}
	}

	@Override
	public String toString() {
		return "player " + name + (score != 0 ? "score " + score : "");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public DeuceStateMachine getStateDeuce() {
		return stateDeuce;
	}

	public void setStateDeuce(DeuceStateMachine stateDeuce) {
		this.stateDeuce = stateDeuce;
	}


}
