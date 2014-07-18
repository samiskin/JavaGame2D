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
	private Vec clicked = null;
	
	public PlanetTest() {
		super(1280,720);
		Game.MAX_FPS = 60;
		Screen.setPixelsPerMeter(20);
		
		// Since the demo requires physics, the world object must be instantiated.
		// Since this will be taken place in space, a gravity of 0 is necessary.
		world = new World(0); 
		
		
		bodies = new ArrayList<PhysEntity>();
		
		
		Planet planet = new Planet(world.createStaticCircle(Screen.getCenter().x, Screen.getCenter().y, 3),new Image("res/images/earth.png"));
		planet.setMass(75);
		//planet.setVel(0, 15);
		bodies.add(planet);
		

		planet = new Planet(world.createDynamicCircle(Screen.getCenter().x+Screen.WIDTH/4, Screen.getCenter().y, 1),new Image("res/images/moon.png"));
		planet.setMass(30);
		planet.setVel(0, 15);
		bodies.add(planet);
		
		planet = new Planet(world.createDynamicCircle(Screen.getCenter().x-Screen.WIDTH/4, Screen.getCenter().y, 1),new Image("res/images/moon.png"));
		planet.setMass(30);
		planet.setVel(0, -15);
		bodies.add(planet);
		
		start();
	}
	
	public void update(){
		
		while (Mouse.next()){
			if (Mouse.isButtonDown(0)){
				Planet body = null;
				body = new Planet(world.createDynamicCircle(Screen.toMeters(Mouse.getX()),Screen.toMeters(Mouse.getY()), 0.5),new Image("res/images/moon.png"));
				
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
					a.applyForceTo(b,-World.GRAVITY_CONST);
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
