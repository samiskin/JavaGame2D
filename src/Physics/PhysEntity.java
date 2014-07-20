package Physics;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import JavaGame.Entity2D;
import JavaGame.Vec;

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
	
	
	public void applyForceTo(PhysEntity target, double coeff){
		Vec2 force = target.getPosition().sub(getPosition());
		double mag = (coeff*getMass()*target.getMass())/force.lengthSquared();
		force.normalize();
		
		force = force.mul((float)mag);

		target.applyForce(force);
	}
	
	public PhysEntity clone(){
		return new PhysEntity(this);
	}
	
	public float getMass(){
		return body.getMass();
	}
	
	public double getX(){
		return getPosition().x;
	}
	

	public double getY() {
		return getPosition().y;
	}
	
	public Vec2 getPosition(){
		return body.getPosition();
	}
	
	
	public double getAngularVelocity()
	{
		return body.getAngularVelocity();
	}
	
	public Vec2 getLinearVelocity()
	{
		return body.getLinearVelocity();
	}
	
	public double getAngle(){
		return body.getAngle();
	}
	
	public void applyForce(Vec2 force){
		body.applyForceToCenter(force);
	}
	
	public void applyForce(Vec2 force, Vec2 point){
		body.applyForce(force, point);
	}

	public void setX(double x) {
		setPosition(x,getY());
	}

	public void setY(double y) {
		setPosition(getX(),y);
	}
	
	public void setDensity(double density){
		body.m_fixtureList.m_density = (float) density;
	}
	
	public void setMass(double mass){
		body.m_mass = (float)mass;
	}
	
	public void setActive(boolean active){
		body.setActive(active);
	}
		
	public void setRestitution(double restitution){
		fixture.m_restitution = (float)restitution;
	}
	
	public void setVel(double x, double y){
		setVel(new Vec(x,y));
	}
	
	public void setVel(Vec v){
		body.setLinearVelocity(v);
	}
	
	public void setLinearVelocity(Vec2 v){
		body.setLinearVelocity(v);
	}
	
	public void setAngularVelocity(double w){
		body.setAngularVelocity((float)w);
	}

	public void setPosition(double x, double y) {
		setPosition(new Vec(x,y));
	}
	
	public void setPosition(Vec2 vec2){
		body.setTransform(vec2, body.getAngle());
	}
	
	public void setFriction(double friction){
		fixture.m_friction = (float)friction;
	}
	
	public float moveX(double dx){
		
		setPosition(getPosition().add(new Vec(dx,0)));
		return bodyDef.position.x;
	}
	
	public float moveY(double dy){
		bodyDef.position.y += dy;
		return bodyDef.position.y;
	}

	public void update() {
		
	}
	
	public void render() {
		
	}

	public Vec2 distanceTo(PhysEntity other){
		return other.getPosition().sub(getPosition());
	}
	
}
