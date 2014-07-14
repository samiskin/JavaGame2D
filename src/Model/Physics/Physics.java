package Model.Physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Model.Generic.Vec;


public class Physics {

	public static World world;
	
	public static void init(World world){
		Physics.world = world;
	}
	
	
	public static void setGravity(double gx, double gy){
		world.setGravity(new Vec(gx,gy));
	}
	
	
	public static PhysCircle createDynamicCircle(double x, double y, double radius){
    	CircleShape shape = new CircleShape();
    	shape.m_radius = (float) radius;
    	FixtureDef fixtureDef = new FixtureDef();
    	fixtureDef.shape = shape;
    	fixtureDef.density = 1f;
    	BodyDef bodyDef = new BodyDef();
    	bodyDef.type = BodyType.DYNAMIC;
    	bodyDef.position.set((float)x, (float)y);
    	Body body = world.createBody(bodyDef);
    	Fixture fixture = body.createFixture(fixtureDef);
    	PhysCircle circle = new PhysCircle(body,fixture,bodyDef,shape); 
    	return circle;    	
	}
	
	public static PhysRect createStaticRect (double x, double y, double width, double height){

		PolygonShape shape = new PolygonShape();
		shape.setAsBox((float)(width/2),(float)(height/2));
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set((float)(x+width/2),(float)(y+height/2));
		Body body = world.createBody(bodyDef);
		FixtureDef fixtureDef = new FixtureDef();
    	fixtureDef.density = 1f;
    	fixtureDef.restitution = 0f;
    	fixtureDef.friction = 0f;
    	fixtureDef.shape = shape;
		Fixture fixture = body.createFixture(fixtureDef);
		PhysRect rect = new PhysRect(body,fixture,bodyDef,shape);
    	return rect;
	}
	
}
