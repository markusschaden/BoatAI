package ch.avendia.boatai.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Collection;

import javax.swing.JFrame;

import ch.avendia.boatai.map.TileMap;

public class SimulationPanel extends JFrame {

	private Surface surface;
	private Dimension size;

	public SimulationPanel(Dimension size, Collection<Point.Double> collection) {
		surface = new Surface(collection);
		this.size = size;
		initUI();

	}

	public SimulationPanel(Dimension size, TileMap tileMap) {
		surface = new Surface(tileMap);
		this.size = size;
		initUI();
	}

	private void initUI() {

		setTitle("Points");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(surface);

		setSize(size);
		setLocationRelativeTo(null);
	}
}
