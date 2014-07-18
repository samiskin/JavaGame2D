package JavaGame;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PhysRect extends PhysEntity implements Rect{

	private ViewComponent view;
	private double width;
	private double height;
	
	public PhysRect(Body body, Fixture fixture, BodyDef bodyDef, Shape shape) {
		super(body, fixture,bodyDef,shape);
		view = new RectView(this);
	}
	
	public PhysRect(PhysEntity entity){
		super(entity);
		view = new RectView(this);
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

	public void render() {
		view.render();
	}

}
