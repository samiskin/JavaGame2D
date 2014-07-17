package Model.Generic;

public abstract class AbstractEntity2D implements Entity2D {
	protected double x;
	protected double y;
	public double getX() { return x; }
	public double getY() { return y; }
        public void setX(double x) { this.x = x; }
        public void setY(double y) { this.y = y; }
        public void setPosition(double x, double y) {
    		this.x = x;
    		this.y = y;
        }
}