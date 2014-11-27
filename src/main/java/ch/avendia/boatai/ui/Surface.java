package ch.avendia.boatai.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Collection;

import javax.swing.JPanel;

import ch.avendia.boatai.map.TileMap;
import ch.avendia.boatai.map.coordinates.CoordinateConverter;
import ch.avendia.boatai.map.finder.AStarPathFinder;
import ch.avendia.boatai.map.finder.Path;
import ch.avendia.boatai.map.finder.PathFinder;
import ch.avendia.boatai.map.finder.UnitMover;
import ch.avendia.boatai.map.tiles.Lake;
import ch.avendia.boatai.ui.logic.RawLakeMapResizer;

public class Surface extends JPanel {

	private Collection<Point.Double> points;
	private RawLakeMapResizer mapResizer;
	private TileMap map;
	private PathFinder finder;
	private Path path;

	/** The x coordinate of selected unit or -1 if none is selected */
	private int selectedx = -1;
	/** The y coordinate of selected unit or -1 if none is selected */
	private int selectedy = -1;
	/** The x coordinate of the target of the last path we searched for - used to cache and prevent constantly re-searching */
	private int lastFindX = -1;
	/** The y coordinate of the target of the last path we searched for - used to cache and prevent constantly re-searching */
	private int lastFindY = -1;

	public Surface(Collection<Point.Double> points) {
		this.points = points;
		mapResizer = new RawLakeMapResizer(points);
	}

	public Surface(TileMap tileMap) {
		this.map = tileMap;
		finder = new AStarPathFinder(tileMap, 500, true);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				handleMousePressed(e.getX(), e.getY());
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
			}

			public void mouseMoved(MouseEvent e) {
				handleMouseMoved(e.getX(), e.getY());
			}
		});

	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.blue);

		if (map != null) {
			for (int i = 0; i < map.getWidthInTiles(); i++) {
				for (int j = 0; j < map.getHeightInTiles(); j++) {
					if (map.getTile(i, j) instanceof Lake) {
						g2d.setColor(Color.blue);
					} else {
						g2d.setColor(Color.gray);
					}
					g2d.fillRect(i * map.getResolution(), j * map.getResolution(), map.getResolution(), map.getResolution());

					g2d.setColor(Color.black);
					// g2d.drawRect(i * map.getResolution(), j * map.getResolution(), map.getResolution(), map.getResolution());

					if (path != null) {
						if (path.contains(i, j)) {
							g.setColor(Color.red);
							g.fillRect(i * map.getResolution(), j * map.getResolution(), map.getResolution(), map.getResolution());
						}
					}

				}
			}

		} else if (points != null) {
			mapResizer.resize(this.getSize());

			Point.Double lastPoint = null;
			if (points != null) {
				for (Point.Double point : points) {

					if (lastPoint != null) {
						g2d.drawLine((int) lastPoint.x, (int) lastPoint.y, (int) point.x, (int) point.y);
					}
					g2d.drawOval((int) point.x - 2, (int) point.y - 2, 4, 4);

					lastPoint = point;
				}
			}

		}

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}

	/**
	 * Handle the mouse being moved. In this case we want to find a path from the selected unit to the position the mouse is at
	 * 
	 * @param x
	 *            The x coordinate of the mouse cursor on the screen
	 * @param y
	 *            The y coordinate of the mouse cursor on the screen
	 */
	private void handleMouseMoved(int x, int y) {
		x /= map.getResolution();
		y /= map.getResolution();

		if ((x < 0) || (y < 0) || (x >= map.getWidthInTiles()) || (y >= map.getHeightInTiles())) {
			return;
		}

		if (selectedx != -1) {
			if ((lastFindX != x) || (lastFindY != y)) {
				lastFindX = x;
				lastFindY = y;
				path = finder.findPath(new UnitMover(0), selectedx, selectedy, x, y);
				repaint(0);
			}
		}
	}

	/**
	 * Handle the mouse being pressed. If the mouse is over a unit select it. Otherwise we move the selected unit to the new target (assuming there was a path found)
	 * 
	 * @param x
	 *            The x coordinate of the mouse cursor on the screen
	 * @param y
	 *            The y coordinate of the mouse cursor on the screen
	 */
	private void handleMousePressed(int x, int y) {
		Point.Double swiss = new Point.Double(x / map.getTransform().getScale() + map.getTransform().getTranslateX(), y / map.getTransform().getScale() + map.getTransform().getTranslateY());
		Point.Double gps = CoordinateConverter.getInstance().convertToGPS(swiss);
		System.out.println("GPS: E " + gps.x + " N " + gps.y);

		x /= map.getResolution();
		y /= map.getResolution();

		if ((x < 0) || (y < 0) || (x >= map.getWidthInTiles()) || (y >= map.getHeightInTiles())) {
			return;
		}

		System.out.println("x:" + x + ", y: " + y);
		if (map.getTile(x, y) instanceof Lake) {
			selectedx = x;
			selectedy = y;
			lastFindX = -1;
		} else {
			if (selectedx != -1) {
				map.clearVisited();
				path = finder.findPath(new UnitMover(0), selectedx, selectedy, x, y);

				if (path != null) {
					path = null;
					/*
					 * int unit = map.getUnit(selectedx, selectedy); map.setUnit(selectedx, selectedy, 0); map.setUnit(x, y, unit);
					 */
					selectedx = x;
					selectedy = y;
					lastFindX = -1;
				}
			}
		}

		repaint(0);
	}

}
