package Deprecated.Physics;

import Deprecated.World;
import JavaGame.Output.Screen;
import JavaGame.Game;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;

public class PhysicsTest extends Game {

    private final double GRAVITY = -9.81;
    private ArrayList<PhysEntity> bodies;
    private World world;

    public PhysicsTest() {
        super(1280, 640);
    }

    public void init() {
        world = new World(GRAVITY);
        bodies = new ArrayList<PhysEntity>();
        PhysRect floor = world.createStaticRect(0, 0, Screen.WIDTH, 0);
        floor.setRestitution(0.5);
        floor.setFriction(1);
        bodies.add(floor);
        super.MAX_FPS = 30;
    }

    public void update() {

        while (Mouse.next()) {
            if (Mouse.isButtonDown(0)) {
                PhysEntity body = world.createDynamicCircle((Mouse.getX()), (Mouse.getY()), 1);
                body.setFriction(1);
                bodies.add(body);

            } else if (Mouse.isButtonDown(1)) {
                PhysEntity body = world.createDynamicRect((Mouse.getX()), (Mouse.getY()), 5, 0.5);
                body.setFriction(1);
                bodies.add(body);
            }
        }

        world.update();
        for (PhysEntity body : bodies) {
            body.update();
        }
    }

    public void render() {
        for (PhysEntity body : bodies) {
            body.render();
        }
    }

}
