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
		return bodyDef.position.x-width/2;		
	}
	
	public double getY(){
		return bodyDef.position.y-width/2;
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
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
	
	public void setX(double x) {
		bodyDef.position.x = (float)(x+width/2);
	}

	public void setY(double y) {
		bodyDef.position.y = (float)(y+width/2);
	}

	public void setLocation(double x, double y) {
		bodyDef.position.set((float)x,(float)y);
	}

	public void update() {
		view.update();
		
	}

}
