package ch.avendia.boatai.zsg;

import java.io.StringReader;
import java.util.Collection;

import ch.avendia.boatai.zsg.json.ZSGJsonParser;
import ch.avendia.boatai.zsg.json.ZSGShip;
import ch.avendia.boatai.zsg.json.ZSGShips;

public class ZSGShipProvider {

	public Collection<ZSGShip> getShips() {

		String json = getJson();

		StringReader reader = new StringReader(getJson());
		ZSGJsonParser parser = new ZSGJsonParser();

		// FileReader filereader = new FileReader("src/main/resources/data/zsg.json");

		ZSGShips ships = parser.parse(reader);

		for (ZSGShip ship : ships.getShips()) {
			System.out.println(ship.getLatitude() + " , " + ship.getLongitude());
		}

		return ships.getActiveShips();
	}

	private String getJson() {

		ZSGAPI api = new ZSGAPI();
		return api.getJson();
	}

}
