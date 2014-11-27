package ch.avendia.boatai.map.coordinates;

import java.awt.Point;

import org.osgeo.proj4j.BasicCoordinateTransform;
import org.osgeo.proj4j.CRSFactory;
import org.osgeo.proj4j.CoordinateReferenceSystem;
import org.osgeo.proj4j.ProjCoordinate;

public class CoordinateConverter {

	private static CoordinateConverter instance;
	private CRSFactory crsFactory;
	CoordinateReferenceSystem swissCRS;
	CoordinateReferenceSystem gpsCRS;
	BasicCoordinateTransform swissToGPS;
	BasicCoordinateTransform gpsToSwiss;

	private CoordinateConverter() {
		crsFactory = new CRSFactory();
		swissCRS = crsFactory.createFromName("EPSG:21781");
		gpsCRS = crsFactory.createFromName("EPSG:4236");
		swissToGPS = new BasicCoordinateTransform(swissCRS, gpsCRS);
		gpsToSwiss = new BasicCoordinateTransform(gpsCRS, swissCRS);
	}

	public static CoordinateConverter getInstance() {
		if (instance == null) {
			synchronized (CoordinateConverter.class) {
				if (instance == null) {
					instance = new CoordinateConverter();
				}
			}
		}

		return instance;
	}

	public Point.Double convertToGPS(Point.Double swiss) {

		ProjCoordinate tCoor = new ProjCoordinate();
		swissToGPS.transform(new ProjCoordinate(swiss.x, swiss.y), tCoor);

		Point.Double targetPoint = new Point.Double(tCoor.x, tCoor.y);
		return targetPoint;

	}

	public Point.Double convertToSwiss(Point.Double gps) {

		ProjCoordinate tCoor = new ProjCoordinate();
		gpsToSwiss.transform(new ProjCoordinate(gps.x, gps.y), tCoor);

		Point.Double targetPoint = new Point.Double(tCoor.x, tCoor.y);
		return targetPoint;

	}

}
