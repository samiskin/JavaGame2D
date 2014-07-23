package Deprecated.Physics;

import Deprecated.Rect;
import Deprecated.RectView;
import Deprecated.ViewComponent;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;

public class PhysRect extends PhysEntity implements Rect {

    private ViewComponent view;
    private double width;
    private double height;

    public PhysRect(Body body, Fixture fixture, BodyDef bodyDef, Shape shape) {
        super(body, fixture, bodyDef, shape);
        init();

    }

    public PhysRect(PhysEntity entity) {
        super(entity);
        init();
    }


    private void init() {
        view = new RectView(this);
        Vec2[] vertices = ((PolygonShape) shape).m_vertices;
        width = vertices[1].x - vertices[0].x;
        height = vertices[3].y - vertices[0].y;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        setSize(width, height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        setSize(width, height);
    }

    public void setAngle(double radians) {
        return;
    }

    public void setSize(double width, double height) {
        this.width = width;
        this.height = height;
        ((PolygonShape) shape).setAsBox((float) width / 2, (float) height / 2);
    }

    public void render() {
        view.render();
    }

}
