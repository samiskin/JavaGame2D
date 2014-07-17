package Model.Physics;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Model.Generic.Rect;
import View.RectView;
import View.ViewComponent;

public class PhysRect extends PhysEntity implements Rect{

	private ViewComponent view;
	private double width;
	private double height;
	
	public PhysRect(Body body, Fixture fixture, BodyDef bodyDef, Shape shape) {
		super(body, fixture,bodyDef,shape);
		view = new RectView(this);
	}

	public double getX(){
		return super.getX()-width/2;		
	}
	
	public double getY(){
		return super.getY()-height/2;
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	
	public void setAngle(double radians){
		return;
	}
	
	public void setSize(double width, double height){
		this.width = width;
		this.height = height;
		((PolygonShape)shape).setAsBox((float)width/2,(float)height/2);
	}
	
	public void setWidth(double width){
		setSize(width, height);
	}
	
	public void setHeight(double height){
		setSize(width, height);
	}

	public void setLocation(double x, double y) {
		super.setLocation(x+width/2, y+height/2);
	}

	public void update() {
		view.update();
	}

}
