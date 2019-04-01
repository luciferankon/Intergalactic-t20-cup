package the_last_four;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.rotate;

class Game {
	private List<Player> team;
	private List<Player> players;
	private int nextPlayerIndex;
	private int balls;
	private int runs;
	private int wicket;

	Game(List<Player> players) {
		this.team = players;
		this.players = team.stream().limit(2).collect(Collectors.toList());
		runs = 0;
		nextPlayerIndex = 2;
		balls = 24;
		wicket = 0;
	}

	boolean isGameNotOver() {
		return players.size() >= 2 && balls > 0 && runs < 40;
	}

	private boolean isOver() {
		return balls % 6 == 0;
	}

	void play() {
		Player striker = players.get(0);
		int run = striker.strike();
		balls--;

		handleRun(striker, run);
//		handleWicket(striker, run);
	}

	private void handleWicket(Player striker) {
			System.out.println(striker.toString() + " got out");
			players.remove(striker);
			wicket++;
			runs++;
			addNextPlayer();
	}

	private void handleRun(Player striker, int run) {
		if(isOut(run)){
			handleWicket(striker);
			return;
		}
		runs += run;
		String commentary = getOvers() + striker.toString() + " scores " + run + " runs";
		System.out.println(commentary);
		striker.addScore(run);
		if (isOdd(run)) changeStriker();
		if (isOver()) {
			System.out.println("\n" + (balls / 6) + " overs left. " + (40 - runs) + " " + "runs " + "to win\n");
			changeStriker();
		}
	}

	private void addNextPlayer() {
		if (team.size() > nextPlayerIndex) players.add(getNextPlayer());
		nextPlayerIndex++;
	}

	private Player getNextPlayer() {
		return team.get(nextPlayerIndex);
	}

	private boolean isOut(int run) {
		return run == -1;
	}

	private boolean isOdd(int number) {
		return number > 0 && number % 2 != 0;
	}

	private void changeStriker() {
		rotate(players, 1);
	}

	private String getOvers() {
		int currentBall = 24 - this.balls;
		return currentBall / 6 + "." + currentBall % 6 + " ";
	}

	String getResult() {
		StringBuilder result = new StringBuilder();
		if (runs >= 40)
			result.append("\nLengaburu won by ").append(4 - wicket).append(" wicket" + " and ").append(balls).append(" ").append("balls remaining\n");
		else
			result.append("\nLengaburu lost by ").append(40 - runs).append(" runs\n");
		for (Player player : team) {
			result.append(player.getStats());
		}
		return result.toString();
	}
}
