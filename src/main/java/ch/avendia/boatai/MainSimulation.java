package ch.avendia.boatai;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingUtilities;

import ch.avendia.boatai.map.TileMap;
import ch.avendia.boatai.map.TileMapFactory;
import ch.avendia.boatai.map.coordinates.CoordinateConverter;
import ch.avendia.boatai.rawlake.FileLakeReader;
import ch.avendia.boatai.rawlake.RawLake;
import ch.avendia.boatai.ui.SimulationPanel;

public class MainSimulation {

	public static void main(String[] args) {

		FileLakeReader fileLakeReader = new FileLakeReader("src/main/resources/data/ch-lakes-4236.json");
		RawLake rawLake = fileLakeReader.getRawLake("Zürichsee");

		for (Point.Double p : rawLake.getPolygonLakes().iterator().next()) {
			System.out.println("x: " + p.x + " , y: " + p.y);
			Point.Double convertedCoordinates = CoordinateConverter.getInstance().convertToGPS(p);

			System.out.println("N: " + convertedCoordinates.y + " , E: " + convertedCoordinates.x);
			System.out.println("---------------------");
		}

		Dimension size = new Dimension(800, 600);

		TileMap tileMap = TileMapFactory.getInstance().getTileMap(rawLake, size, 4);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				SimulationPanel panel = new SimulationPanel(size, tileMap);
				panel.setVisible(true);
			}
		});

	}
}
