package Planets;


import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Fixture;

import JavaGame.Image;
import JavaGame.PhysCircle;
import JavaGame.PhysEntity;

public class Planet extends PhysCircle{

	Image img;
	public Planet(PhysEntity entity, Image img) {
		super(entity);
		view = new PlanetView(this);
		this.img = img;
	}

}
