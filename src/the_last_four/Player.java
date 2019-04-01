package the_last_four;

abstract class Player {
	int[] runs;
	private String name;
	private int score;
	private int ballsPlayed;

	Player(String name) {
		this.score = 0;
		this.runs = new int[]{-1, 0, 1, 2, 3, 4, 5, 6};
		this.name = name;
		this.ballsPlayed = 0;
	}

	abstract int strike();

	@Override
	public String toString() {
		return name;
	}

	void addScore(int run) {
		score += run;
		ballsPlayed++;
	}

	String getStats() {
		return name + " - " + score + "(" + ballsPlayed + " balls )\n";
	}
}
