package ch.avendia.boatai.map;

import ch.avendia.boatai.map.finder.Mover;
import ch.avendia.boatai.map.finder.TileBasedMap;
import ch.avendia.boatai.map.tiles.Lake;
import ch.avendia.boatai.map.tiles.Tile;
import ch.avendia.boatai.map.units.Ship;
import ch.avendia.boatai.map.units.Unit;

public class TileMap implements TileBasedMap {

	private Tile[][] tiles;
	private Unit[][] units;
	private boolean[][] visited;
	private int resolution; // Defines how many pixel are grouped together
	private int width, height;

	private Transform transform;
	private Location location;

	public TileMap(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		visited = new boolean[width][height];
		units = new Unit[width][height];
		location = new Location();
	}

	public void setTile(int x, int y, Tile tile) {
		tiles[x][y] = tile;
	}

	public int getWidthInTiles() {
		return width;
	}

	public int getHeightInTiles() {
		return height;
	}

	/**
	 * @see TileBasedMap#pathFinderVisited(int, int)
	 */
	public void pathFinderVisited(int x, int y) {
		visited[x][y] = true;
	}

	/**
	 * @see TileBasedMap#getCost(Mover, int, int, int, int)
	 */
	public float getCost(Mover mover, int sx, int sy, int tx, int ty) {
		return 1;
	}

	/**
	 * @see TileBasedMap#blocked(Mover, int, int)
	 */
	public boolean blocked(Mover mover, int x, int y) {
		Unit unit = units[x][y];
		if (unit instanceof Ship) {
			return true;
		}

		return !(tiles[x][y] instanceof Lake);
	}

	/**
	 * Clear the array marking which tiles have been visted by the path finder.
	 */
	public void clearVisited() {
		for (int x = 0; x < getWidthInTiles(); x++) {
			for (int y = 0; y < getHeightInTiles(); y++) {
				visited[x][y] = false;
			}
		}
	}

	/**
	 * @see TileBasedMap#visited(int, int)
	 */
	public boolean visited(int x, int y) {
		return visited[x][y];
	}

	public void setUnit(int x, int y, Unit unit) {
		units[x][y] = unit;
	}

	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public Unit getUnit(int x, int y) {
		return units[x][y];
	}

	public void setLocation(int x, int y) {
		location.setCurrentX(x);
		location.setCurrentY(y);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
