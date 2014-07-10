package Model;

public interface Entity2D {
	public double getX();
	public double getY();
    public void setX(double x);
    public void setY(double y);
    public void setLocation(double x, double y);
	public void setUp();
	public void destroy();
	public void draw();
}