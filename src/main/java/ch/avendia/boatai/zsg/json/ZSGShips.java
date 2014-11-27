package ch.avendia.boatai.zsg.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ZSGShips extends HashMap<Integer, List<ZSGShip>> {

	private static final long serialVersionUID = 1817921559246587391L;

	public Collection<ZSGShip> getShips() {
		Collection<ZSGShip> zsgShips = new ArrayList<ZSGShip>();
		for (List<ZSGShip> list : values()) {
			for (ZSGShip ship : list) {
				zsgShips.add(ship);
			}
		}
		return zsgShips;
	}

	public Collection<ZSGShip> getActiveShips() {

		return getShips().stream().filter(s -> s.getActive()).collect(Collectors.toList());
	}
}
