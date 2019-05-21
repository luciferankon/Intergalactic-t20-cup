package the_tie_breaker;

public class DBVellyers extends Player {

	DBVellyers(String name) {
		super(name);
	}

	@Override
	int strike() {
		double number = Math.random();
		if (number < 0.1) return runs[0];
		if (number < 0.15) return runs[1];
		if (number < 0.25) return runs[2];
		if (number < 0.5) return runs[3];
		if (number < 0.6) return runs[4];
		if (number < 0.85) return runs[5];
		if (number < 0.86) return runs[6];
		return runs[7];
	}
}
