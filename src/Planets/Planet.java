package Planets;


import Deprecated.Physics.PhysCircle;
import Deprecated.Physics.PhysEntity;
import JavaGame.Display.Image;

public class Planet extends PhysCircle {

    Image img;

    public Planet(PhysEntity entity, Image img) {
        super(entity);
        view = new PlanetView(this);
        this.img = img;
    }

}
