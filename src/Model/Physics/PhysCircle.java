package Model.Physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Model.Generic.Circle;
import Model.Generic.Entity2D;
import View.CircleView;
import View.ViewComponent;

public class PhysCircle extends PhysEntity implements Circle{

	protected ViewComponent view;
	
	public PhysCircle(Body body, Fixture fixture, BodyDef bodyDef, Shape shape) {
		super(body,fixture,bodyDef,shape);		
		view = new CircleView(this);
	}
	
	public PhysCircle(PhysEntity entity){
		super(entity);
		view = new CircleView(this);
	}
	
	
	public double getRadius(){
		return shape.m_radius;
	}


	public void update() {
		view.update();		
	}




}
