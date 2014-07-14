package Main;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import Model.Physics.PhysCircle;
import Model.Physics.PhysEntity;
import Model.Physics.PhysRect;
import Model.Physics.World;

public class PhysicsTest extends Game{
	
	private ArrayList<PhysEntity> bodies;
	private World world;
	private final double GRAVITY = 9.81;
	
	public PhysicsTest() {
		super(1280, 720);
		world = new World(GRAVITY);
		bodies = new ArrayList<PhysEntity>();
		PhysRect floor = world.createStaticRect(0, Screen.HEIGHT, Screen.WIDTH, 0);
		floor.setRestitution(0.9);
		bodies.add(floor);
		Game.MAX_FPS = 30;
		start();
	}
	
	public void update(){
		
		while (Mouse.next()){
		if (Mouse.isButtonDown(0)){
			bodies.add(world.createDynamicCircle(Mouse.getX()/Screen.PIXELS_PER_METER, Mouse.getY()/Screen.PIXELS_PER_METER, Math.random()*2));
		}
		}
		world.update();
		for (PhysEntity body : bodies){
			body.update();
		}
	}
	
	
	public static void main(String[] args){
		Game game = new PhysicsTest();
	}

}
