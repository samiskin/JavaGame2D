package Deprecated.Planets;


import Deprecated.Physics.PhysEntity;
import Deprecated.Physics.PhysScreen;
import Deprecated.World;
import JavaGame.Output.Image;
import JavaGame.Game;
import org.jbox2d.common.Vec2;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;

public class PlanetTest extends Game {

    private ArrayList<PhysEntity> bodies;
    private World world;
    private Vec2 clicked = null;

    public PlanetTest() {
        super(1280, 720);
    }

    public void init() {

        Game.MAX_FPS = 60;
        PhysScreen.setPixelsPerMeter(20);

        // Since the demo requires physics, the world object must be instantiated.
        // Since this will be taken place in space, a gravity of 0 is necessary.
        world = new World(0);


        bodies = new ArrayList<PhysEntity>();


        Planet planet = new Planet(world.createStaticCircle(PhysScreen.getCenter().x, PhysScreen.getCenter().y, 3), new Image("res/images/earth.png"));
        planet.setMass(75);
        //planet.setVel(0, 15);
        bodies.add(planet);


        planet = new Planet(world.createDynamicCircle(PhysScreen.getCenter().x + PhysScreen.width / 4, PhysScreen.getCenter().y, 1), new Image("res/images/moon.png"));
        planet.setMass(30);
        planet.setVel(0, 15);
        //bodies.add(planet);

        planet = new Planet(world.createDynamicCircle(PhysScreen.getCenter().x - PhysScreen.width / 4, PhysScreen.getCenter().y, 1), new Image("res/images/moon.png"));
        planet.setMass(30);
        planet.setVel(0, -15);
        //bodies.add(planet);
    }

    public void update() {

        while (Mouse.next()) {
            Vec2 point = new Vec2((float)PhysScreen.toMeters(Mouse.getX()), (float) PhysScreen.toMeters(Mouse.getY()));
            if (clicked != null && !Mouse.isButtonDown(0)) {
                Vec2 vel = point.sub(clicked);
                Planet body = new Planet(world.createDynamicCircle(clicked.x, clicked.y, 0.5), new Image("res/images/moon.png"));

                body.setVel(vel);
                body.setMass(1);
                bodies.add(body);

                clicked = null;
            } else if (clicked == null && Mouse.isButtonDown(0)) {
                clicked = new Vec2(point);
            }
        }


        for (int i = 0; i < bodies.size(); i++) {
            for (int j = 1; j < bodies.size(); j++) {
                PhysEntity a = bodies.get(i);
                PhysEntity b = bodies.get(j);
                if (a.distanceTo(b).lengthSquared() > 0.01) {
                    a.applyForceTo(b, -World.GRAVITY_CONST);
                }
            }
        }
        world.update();
        for (PhysEntity body : bodies) {
            body.update();
        }
    }

    @Override
    protected void render() {
        for (PhysEntity body : bodies) {
            body.render();
        }

    }


}
