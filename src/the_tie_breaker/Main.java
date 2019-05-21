package the_tie_breaker;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Player kiratBoli = new KiratBoli("Kirat Boli");
		Player nsNodhi = new NSNodhi("NS Nodhi");

		List<Player> players = new ArrayList<>(2);
		players.add(kiratBoli);
		players.add(nsNodhi);

		Innings firstInnings = new Innings(players);
		while (firstInnings.isInningsNotOver()) {
			firstInnings.play();
		}
		System.out.println(firstInnings.getResult());
	}
}
