package Model.Physics;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Model.Generic.Entity2D;
import Model.Generic.Vec;

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
	
	public PhysEntity(PhysEntity src){
		this.body = src.body;
		this.fixture = src.fixture;
		this.bodyDef = src.bodyDef;
		this.shape = src.shape;
	}
	
	public PhysEntity clone(){
		return new PhysEntity(this);
	}
	
	public double getX(){
		return body.getPosition().x;
	}

	public double getY() {
		return body.getPosition().y;
	}
	
	public Vec getPosition(){
		return new Vec(body.getPosition());
	}
	
	
	public double getAngularVelocity()
	{
		return body.getAngularVelocity();
	}
	
	public Vec getLinearVelocity()
	{
		return new Vec(body.getLinearVelocity());
	}
	
	public double getAngle(){
		return body.getAngle();
	}
	
	public void applyForce(Vec force){
		body.applyForceToCenter(force);
	}
	
	public void applyForce(Vec force, Vec point){
		body.applyForce(force, point);
	}

	public void setX(double x) {
		setLocation(x,getY());
	}

	public void setY(double y) {
		setLocation(getX(),y);
	}
	
	public void setDensity(double density){
		body.m_fixtureList.m_density = (float) density;
	}
	
	public void setActive(boolean active){
		body.setActive(active);
	}
		
	public void setRestitution(double restitution){
		fixture.m_restitution = (float)restitution;
	}
	
	public void setVel(double x, double y){
		body.setLinearVelocity(new Vec2((float)x,(float)y));
	}
	
	public void setLinearVelocity(Vec v){
		body.setLinearVelocity(v);
	}
	
	public void setAngularVelocity(double w){
		body.setAngularVelocity((float)w);
	}

	public void setLocation(double x, double y) {
		setLocation(new Vec(x,y));
	}
	
	public void setLocation(Vec v){
		body.setTransform(v, body.getAngle());
	}
	
	public void setFriction(double friction){
		fixture.m_friction = (float)friction;
	}
	
	public float moveX(double dx){
		bodyDef.position.x += dx;
		return bodyDef.position.x;
	}
	
	public float moveY(double dy){
		bodyDef.position.y += dy;
		return bodyDef.position.y;
	}

	public void update() {
		
	}

	
	
}
