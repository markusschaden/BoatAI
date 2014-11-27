package ch.avendia.boatai.map;

public class Location {

	private int currentX;
	private int currentY;
	private double currentLatitude;
	private double currentLontitude;
	private double currentSpeed;

	public Location() {
		currentX = -1;
		currentY = -1;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentLontitude() {
		return currentLontitude;
	}

	public void setCurrentLontitude(double currentLontitude) {
		this.currentLontitude = currentLontitude;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

}
