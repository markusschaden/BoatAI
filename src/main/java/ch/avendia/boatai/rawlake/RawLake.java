package ch.avendia.boatai.rawlake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

public class RawLake {

	private Collection<Collection<Point.Double>> polygonLakes;
	private String name;

	public RawLake(String name) {
		this.name = name;

		polygonLakes = new ArrayList<Collection<Point.Double>>();
	}

	public void addPolygonLake(Collection<Point.Double> polygonLake) {
		polygonLakes.add(polygonLake);
	}

	public Collection<Collection<Point.Double>> getPolygonLakes() {
		return polygonLakes;
	}

	public String getName() {
		return name;
	}
}
