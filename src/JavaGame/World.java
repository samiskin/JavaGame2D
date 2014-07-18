package JavaGame;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;

public class World extends org.jbox2d.dynamics.World{

	public static final double GRAVITY_CONST = 6.67384;
	
	public World(double gravityY){
		this(0,gravityY);
	}
	
	public World(double gravityX, double gravityY) {
		super(new Vec(gravityX,gravityY));
	}
	
	public void update(){
		step(1.0f/Game.MAX_FPS,8,3);
	}
	
	public void setGravity(double gx, double gy){
		setGravity(new Vec(gx,gy));
	}
	
	public void enableWalls(boolean up, boolean right, boolean down, boolean left, double width, double height, double restitution){
		if (up){
			PhysRect wall = createStaticRect(width/2,height,width,0);
			wall.setRestitution(restitution);
		}
		if (right){
			PhysRect wall = createStaticRect(width,height/2,0,height);
			wall.setRestitution(restitution);
		}
		if (down){
			PhysRect wall = createStaticRect(width/2,0,width,0);
			wall.setRestitution(restitution);
		}
		if (left){
			PhysRect wall = createStaticRect(0,height/2,0,height);
			wall.setRestitution(restitution);
		}
	}
	
	private PhysEntity createEntity(Shape shape, BodyDef bodyDef, FixtureDef fixture){
		Body body = createBody(bodyDef);
		PhysEntity entity = new PhysEntity(body,body.createFixture(fixture),bodyDef,shape);
		return entity;
	}
	
	private BodyDef getBodyDef(double x, double y, BodyType type){
    	BodyDef bodyDef = new BodyDef();
    	bodyDef.type = type;
    	bodyDef.position.set((float)x, (float)y);
    	return bodyDef;
	}
	
	private FixtureDef getFixtureDef(double density, double restitution, double friction, Shape shape){
		FixtureDef fixtureDef = new FixtureDef();
    	fixtureDef.density = (float)density;
    	fixtureDef.restitution = (float)restitution;
    	fixtureDef.friction = (float)friction;
    	fixtureDef.shape = shape;
    	return fixtureDef;
	}
	
	private CircleShape getCircleShape(double radius){
		CircleShape shape = new CircleShape();
		shape.m_radius = (float) radius;
		return shape;
	}
	
	private PolygonShape getRectShape(double width, double height){
		PolygonShape shape = new PolygonShape();
		shape.setAsBox((float)(width/2),(float)(height/2));
		return shape;
	}
	
	public PhysCircle createStaticCircle(double x, double y, double radius){
    	CircleShape shape = getCircleShape(radius);
    	FixtureDef fixtureDef = getFixtureDef(1,0,0,shape);
    	BodyDef bodyDef = getBodyDef(x,y,BodyType.STATIC);
    	Body body = createBody(bodyDef);
    	Fixture fixture = body.createFixture(fixtureDef);
    	PhysCircle circle = new PhysCircle(body,fixture,bodyDef,shape); 
    	return circle;    	
	}
	
	
	public PhysCircle createDynamicCircle(double x, double y, double radius){
    	CircleShape shape = getCircleShape(radius);
    	FixtureDef fixtureDef = getFixtureDef(1,0,0,shape);
    	BodyDef bodyDef = getBodyDef(x,y,BodyType.DYNAMIC);
    	Body body = createBody(bodyDef);
    	Fixture fixture = body.createFixture(fixtureDef);
    	PhysCircle circle = new PhysCircle(body,fixture,bodyDef,shape); 
    	return circle;    	
	}
	
	public PhysRect createStaticRect (double x, double y, double width, double height){

		PolygonShape shape = getRectShape(width,height);
		BodyDef bodyDef = getBodyDef(x,y,BodyType.STATIC);
		Body body = createBody(bodyDef);
		FixtureDef fixtureDef = getFixtureDef(1,0,0,shape);
		Fixture fixture = body.createFixture(fixtureDef);
		PhysRect rect = new PhysRect(body,fixture,bodyDef,shape);
		rect.setSize(width, height);
    	return rect;
	}
	
	public PhysRect createDynamicRect(double x, double y, double width, double height){
		PolygonShape shape = getRectShape(width,height);
		BodyDef bodyDef = getBodyDef(x,y,BodyType.DYNAMIC);
		Body body = createBody(bodyDef);
		FixtureDef fixtureDef = getFixtureDef(1,0,0,shape);
		Fixture fixture = body.createFixture(fixtureDef);
		PhysRect rect = new PhysRect(body,fixture,bodyDef,shape);
		rect.setSize(width, height);
    	return rect;
	}
	
}
