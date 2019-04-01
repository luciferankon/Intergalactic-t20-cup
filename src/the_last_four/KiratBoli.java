package the_last_four;

class KiratBoli extends Player {

	KiratBoli(String name) {
		super(name);
	}

	int strike() {
		double number = Math.random();
		if (number < 0.05) return runs[0];
		if (number < 0.1) return runs[1];
		if (number < 0.4) return runs[2];
		if (number < 0.65) return runs[3];
		if (number < 0.75) return runs[4];
		if (number < 0.9) return runs[5];
		if (number < 0.91) return runs[6];
		return runs[7];
	}
}
