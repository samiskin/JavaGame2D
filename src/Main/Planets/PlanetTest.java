package Main.Planets;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.lwjgl.input.Mouse;

import Main.Game;
import Main.Screen;
import Model.Generic.Vec;
import Model.Physics.PhysCircle;
import Model.Physics.PhysEntity;
import Model.Physics.PhysPoly;
import Model.Physics.PhysRect;
import Model.Physics.World;
import View.Image;

public class PlanetTest extends Game{
	
	private ArrayList<PhysEntity> bodies;
	private World world;
	private final double GRAVITY = 0;
	private Vec clicked = null;
	
	public PlanetTest() throws IOException {
		super(1280,720);
		world = new World(GRAVITY);
		bodies = new ArrayList<PhysEntity>();
		Game.MAX_FPS = 60;
		Screen.setPixelsPerMeter(20);
		Planet planet = new Planet(world.createStaticCircle(Screen.getCenter().x, Screen.getCenter().y, 3),new Image("res/images/earth.png"));
		planet.setMass(75);
		//planet.setVel(0, 15);
		bodies.add(planet);
		

		planet = new Planet(world.createDynamicCircle(Screen.getCenter().x+Screen.WIDTH/4, Screen.getCenter().y, 1),new Image("res/images/moon.png"));
		planet.setMass(30);
		planet.setVel(0, 15);
		bodies.add(planet);
		
		start();
	}
	
	public void update(){
		
		while (Mouse.next()){
			if (Mouse.isButtonDown(0)){
				Planet body = null;
				try {
					body = new Planet(world.createDynamicCircle(Screen.toMeters(Mouse.getX()),Screen.toMeters(Mouse.getY()), 0.5),new Image("res/images/moon.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				body.setFriction(1);
				body.applyForce((new Vec(Mouse.getDX(), Mouse.getDY())).mul(10));
				body.setMass(1);
				bodies.add(body);
			}
		}
		

		for (int i = 0; i < bodies.size(); i++){
			for (int j = 1; j < bodies.size(); j++){
				PhysEntity a = bodies.get(i);
				PhysEntity b = bodies.get(j);
				if (a.distanceTo(b).lengthSquared() > 0.01){
					bodies.get(i).applyForceTo(bodies.get(j),-World.GRAVITY_CONST);
				}
			}
		}
		world.update();
		for (PhysEntity body : bodies){
			body.update();
		}
	}
	
	public static void main(String[] args) throws IOException{
		Game game = new PlanetTest();
	}
	

}
