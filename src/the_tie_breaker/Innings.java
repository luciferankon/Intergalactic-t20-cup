package the_tie_breaker;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.rotate;

class Innings {
	private List<Player> team;
	private List<Player> currentPlayers;
	private int nextPlayerIndex;
	private int balls;
	private int runs;
	private int wicket;

	Innings(List<Player> players) {
		this.team = players;
		this.currentPlayers = team.stream().limit(2).collect(Collectors.toList());
		runs = 0;
		nextPlayerIndex = 2;
		balls = 6;
		wicket = 0;
	}

	boolean isInningsNotOver() {
		return currentPlayers.size() >= 2 && balls > 0 && runs < 40;
	}

	private boolean isOver() {
		return balls % 6 == 0;
	}

	void play() {
		Player striker = currentPlayers.get(0);
		int run = striker.strike();
		balls--;

		handleRun(striker, run);
	}

	private void handleWicket(Player striker) {
		striker.addScore(0);
		currentPlayers.remove(striker);
		wicket++;
		addNextPlayer();
		System.out.println(striker.toString() + " got out");
	}

	private void handleRun(Player striker, int run) {
		if (isOut(run)) {
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
		if (team.size() > nextPlayerIndex) currentPlayers.add(getNextPlayer());
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
		rotate(currentPlayers, 1);
	}

	private String getOvers() {
		int currentBall = 6 - this.balls;
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
