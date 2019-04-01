package the_last_four;

class RRumrah extends Player {

	RRumrah(String name) {
		super(name);
	}

	@Override
	int strike() {
		double number = Math.random();
		if (number < 0.2) return runs[0];
		if (number < 0.4) return runs[1];
		if (number < 0.7) return runs[2];
		if (number < 0.85) return runs[3];
		if (number < 0.9) return runs[4];
		if (number < 0.95) return runs[5];
		if (number < 0.96) return runs[6];
		return runs[7];
	}
}
