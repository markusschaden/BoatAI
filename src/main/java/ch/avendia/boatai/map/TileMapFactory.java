package ch.avendia.boatai.map;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Collection;

import ch.avendia.boatai.map.coordinates.CoordinateConverter;
import ch.avendia.boatai.map.tiles.Ground;
import ch.avendia.boatai.map.tiles.Lake;
import ch.avendia.boatai.map.units.Ship;
import ch.avendia.boatai.rawlake.LakeFactory;
import ch.avendia.boatai.rawlake.RawLake;
import ch.avendia.boatai.ui.logic.RawLakeMapResizer;
import ch.avendia.boatai.zsg.ZSGShipProvider;
import ch.avendia.boatai.zsg.json.ZSGShip;

public class TileMapFactory {

	private static TileMapFactory instance;

	private TileMapFactory() {
	}

	public static TileMapFactory getInstance() {
		if (instance == null) {
			synchronized (LakeFactory.class) {
				if (instance == null) {
					instance = new TileMapFactory();
				}
			}
		}

		return instance;
	}

	public TileMap getTileMap(RawLake rawLake, Dimension size, int resolution) {

		Collection<Point.Double> points = rawLake.getPolygonLakes().iterator().next();

		RawLakeMapResizer r = new RawLakeMapResizer(points);
		Transform transform = r.resize(size);

		int distX = (int) Math.ceil(r.getMaxX() / resolution);
		int distY = (int) Math.ceil(r.getMaxY() / resolution);
		TileMap tileMap = new TileMap(distX, distY);
		tileMap.setTransform(transform);
		tileMap.setResolution(resolution);

		Polygon polygon = new Polygon();

		int MAX_Y = 0;
		for (Point.Double p : points) {
			if (p.y > MAX_Y) {
				MAX_Y = (int) p.y;
			}
			System.out.println("polygon x:" + p.x + " ,y: " + p.y);
			polygon.addPoint((int) p.x, (int) p.y);
		}
		// swap x Axis
		for (int i = 0; i < polygon.ypoints.length; i++) {
			// polygon.ypoints[i] = MAX_Y - polygon.ypoints[i];
		}

		System.out.println("Map: x:" + distX + " , y:" + distY);

		double[][] coordinates = new double[tileMap.getWidthInTiles()][tileMap.getHeightInTiles()];

		for (int y = 0; y < distY; y++) {
			for (int x = 0; x < distX; x++) {
				if (polygon.contains(x * resolution, y * resolution, resolution, resolution)) {
					// SEE
					tileMap.setTile(x, y, new Lake());
				} else if (polygon.intersects(x * resolution, y * resolution, resolution, resolution)) {
					// SEE und UFER
					tileMap.setTile(x, y, new Lake());
				} else {
					// UFER
					tileMap.setTile(x, y, new Ground());
				}
			}
		}

		ZSGShipProvider provider = new ZSGShipProvider();
		Collection<ZSGShip> ships = provider.getShips();

		for (ZSGShip ship : ships) {
			Point.Double coord = CoordinateConverter.getInstance().convertToSwiss(new Point.Double(ship.getLongitude(), ship.getLatitude()));
			int x = (int) ((coord.x - tileMap.getTransform().getTranslateX()) * tileMap.getTransform().getScale());
			int y = (int) ((coord.y - tileMap.getTransform().getTranslateY()) * tileMap.getTransform().getScale());
			for (int i = -1; i < 2; i++) { // bigger place
				for (int j = -1; j < 2; j++) {
					tileMap.setUnit((int) Math.ceil(x / tileMap.getResolution()) + i, (int) Math.ceil(y / tileMap.getResolution()) + j, new Ship());
				}
			}

		}

		return tileMap;

	}
}
