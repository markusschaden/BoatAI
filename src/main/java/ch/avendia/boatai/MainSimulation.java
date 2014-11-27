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
import ch.avendia.boatai.zsg.ZSGShipProvider;

public class MainSimulation {

	public static void main(String[] args) {

		ZSGShipProvider provider = new ZSGShipProvider();
		// provider.getShips();

		/*
		 * CRSFactory crsFactory = new CRSFactory();
		 * 
		 * CoordinateReferenceSystem source = crsFactory.createFromName("EPSG:21781"); CoordinateReferenceSystem target = crsFactory.createFromName("EPSG:4236"); BasicCoordinateTransform basicCoordinateTransform = new BasicCoordinateTransform(source, target);
		 */
		FileLakeReader fileLakeReader = new FileLakeReader("src/main/resources/data/ch-lakes-4236.json");
		RawLake rawLake = fileLakeReader.getRawLake("Zürichsee");

		for (Point.Double p : rawLake.getPolygonLakes().iterator().next()) {
			System.out.println("x: " + p.x + " , y: " + p.y);
			// ProjCoordinate tCoor = new ProjCoordinate();
			// basicCoordinateTransform.transform(new ProjCoordinate(p.x, p.y), tCoor);
			Point.Double tCoor = CoordinateConverter.getInstance().convertToGPS(p);

			System.out.println("N: " + tCoor.y + " , E: " + tCoor.x);
			System.out.println("---------------------");
		}

		Dimension size = new Dimension(800, 600);

		TileMap tileMap = TileMapFactory.getInstance().getTileMap(rawLake, size, 1);

		// CoordinateTransformFactory coordinateTransformFactory = new CoordinateTransformFactory();
		// coordinateTransformFactory.createTransform(source, target);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				SimulationPanel panel = new SimulationPanel(size, tileMap);
				panel.setVisible(true);
			}
		});

	}
}
