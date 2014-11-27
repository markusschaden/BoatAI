package ch.avendia.boatai.ui.logic;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Collection;
import java.util.Optional;

import ch.avendia.boatai.map.Transform;

public class RawLakeMapResizer {

	Collection<Point.Double> points;
	int correctionX = 0;// 4100;
	int correctionY = 0;// 800;
	Dimension size;

	public RawLakeMapResizer(Collection<Point.Double> points) {
		this.points = points;
	}

	public Transform resize(Dimension size) {
		this.size = size;

		Transform transform = new Transform();

		double[] translate = calcCorrection();
		transform.setTranslateX(translate[0]);
		transform.setTranslateY(translate[1]);
		applyCorrection();

		double scale = applyFactor();
		transform.setScale(scale);

		return transform;
	}

	public Double getMaxX() {
		return points.stream().map(p -> p.x).max(Double::compare).get().doubleValue();
	}

	public Double getMaxY() {
		return points.stream().map(p -> p.y).max(Double::compare).get().doubleValue();
	}

	private double applyFactor() {
		Optional<Double> maxX = points.stream().map(p -> p.x).max(Double::compare);

		int width = size.width;
		double factorX = width / maxX.get().doubleValue();

		Optional<Double> maxY = points.stream().map(p -> p.y).max(Double::compare);

		int height = size.height;
		double factorY = height / maxY.get().doubleValue();

		double factor = factorX < factorY ? factorX : factorY;

		for (Point.Double p : points) {
			p.x *= factor;
			p.y *= factor;
		}

		System.out.println("Factor: " + factor);

		return factor;
	}

	private double[] calcCorrection() {
		Optional<Double> minX = points.stream().map(p -> p.x).min(Double::compare);

		correctionX = (int) (minX.get().doubleValue());

		Optional<Double> minY = points.stream().map(p -> p.y).min(Double::compare);

		correctionY = (int) minY.get().doubleValue();

		return new double[] { minX.get().doubleValue(), minY.get().doubleValue() };
	}

	private void applyCorrection() {
		for (Point.Double p : points) {
			p.x -= correctionX;
			p.y -= correctionY;
		}

		System.out.println("CorrectionX: " + correctionX);
		System.out.println("CorrectionY: " + correctionY);

		correctionX = 0;
		correctionY = 0;
	}

}
