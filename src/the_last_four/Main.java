package the_last_four;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Player kiratBoli = new KiratBoli("Kirat Boli");
		Player nsNodhi = new NSNodhi("N.S. Nodhi");
		Player rRumrah = new RRumrah("R. Rumrah");
		Player shashiHenra = new ShashiHenra("Shashi Henra");

		List<Player> players = new ArrayList<>(4);

		players.add(kiratBoli);
		players.add(nsNodhi);
		players.add(rRumrah);
		players.add(shashiHenra);

		Game game = new Game(players);

		while (game.isGameNotOver()) game.play();
		System.out.println(game.getResult());
	}
}
