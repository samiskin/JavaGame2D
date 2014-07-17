package Model.Physics;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;

import Model.Generic.Poly;
import Model.Generic.Vec;
import View.PolyView;
import View.ViewComponent;

public class PhysPoly extends PhysEntity implements Poly{

	private ViewComponent view;
	private PolygonShape shape;
	
	public PhysPoly(Body body, Fixture fixture, BodyDef bodyDef, Shape shape) {
		super(body, fixture, bodyDef, shape);
		view = new PolyView(this);
	}

	
	public Vec[] getPoints() {		
		Vec[] points = new Vec[shape.m_vertices.length];
		for (int i = 0; i < points.length; i++){
			points[i] = new Vec(shape.m_vertices[i]);
		}
		return points;
	}

	@Override
	public Vec getPoint(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
