package Physics;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import JavaGame.Game;
import JavaGame.Display.Screen;

public class PhysicsTest extends Game{
	
	private ArrayList<PhysEntity> bodies;
	private World world;
	private final double GRAVITY = -9.81;
	
	public PhysicsTest() {
		super(1280,640);
	}

	public void init(){
		world = new World(GRAVITY);
		bodies = new ArrayList<PhysEntity>();
		PhysRect floor = world.createStaticRect(0, 0, Screen.WIDTH, 0);
		Screen.setPixelsPerMeter(30);
		floor.setRestitution(0.5);
		floor.setFriction(1);		
		bodies.add(floor);
		super.MAX_FPS = 30;
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
	
	public void render(){
		for (PhysEntity body : bodies){
			body.render();
		}
	}
	
	
	public static void main(String[] args){
		Game game = new PhysicsTest();
	}

}
