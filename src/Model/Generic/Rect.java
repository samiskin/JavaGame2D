package Model.Generic;

public interface Rect extends Entity2D{
	public double getWidth();
	public double getHeight();	
	public void setWidth(double width);
	public void setHeight(double height);
	public void setSize(double width, double height);
}
