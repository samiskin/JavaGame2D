package Main;

import java.awt.Color;
import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.lwjgl.input.Mouse;

import Model.Physics.PhysCircle;
import Model.Physics.PhysEntity;
import Model.Physics.PhysPoly;
import Model.Physics.PhysRect;
import Model.Physics.World;

public class PlanetTest extends Game{
	
	private ArrayList<PhysEntity> bodies;
	private World world;
	private final double GRAVITY = -9.81;
	
	public PlanetTest() {
		super(480,320);
		world = new World(GRAVITY);
		bodies = new ArrayList<PhysEntity>();
		Game.MAX_FPS = 30;
		
		PhysCircle planet = world.createDynamicCircle(Screen.CENTER_X, Screen.CENTER_Y, 5);
		
		
		start();
	}
	
	public void update(){
		
		while (Mouse.next()){
			if (Mouse.isButtonDown(0)){
				PhysEntity body = world.createDynamicCircle(Screen.toMeters(Mouse.getX()),Screen.toMeters(Mouse.getY()), 1);
				body.setFriction(1);
				bodies.add(body);
				
			} else if (Mouse.isButtonDown(1)){
				PhysEntity body = world.createDynamicRect(Screen.toMeters(Mouse.getX()),Screen.toMeters(Mouse.getY()), 5, 0.5);
				body.setFriction(1);
				bodies.add(body);				
			}			
		}
		
		
		world.update();
		for (PhysEntity body : bodies){
			body.update();
		}
	}
	

}
