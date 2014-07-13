package Model.Physics;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Model.Generic.Entity2D;

public class PhysEntity implements Entity2D{

	protected Shape shape;
	protected Fixture fixture;
	protected BodyDef bodyDef;
	protected Body body;
	
	public PhysEntity(Body body, Fixture fixture, BodyDef bodyDef, Shape shape) {
		this.body = body;
		this.fixture = fixture;
		this.bodyDef = bodyDef;
		this.shape = shape;
		
	}
	
	public double getX(){
		return body.getPosition().x;
	}

	public double getY() {
		return body.getPosition().y;
	}	

	public void setX(double x) {
		bodyDef.position.x = (float)x;
	}

	public void setY(double y) {
		bodyDef.position.y = (float)y;
	}
	
	public void setRestitution(double restitution){
		fixture.m_restitution = (float)restitution;
	}
	
	public void setVel(double x, double y){
		body.setLinearVelocity(new Vec2((float)x,(float)y));
	}

	public void setLocation(double x, double y) {
		bodyDef.position.set((float)x,(float)y);
	}
	
	public float moveX(double dx){
		bodyDef.position.x += dx;
		return bodyDef.position.x;
	}
	
	public float moveY(double dy){
		bodyDef.position.y += dy;
		return bodyDef.position.y;
	}

	
	
}
