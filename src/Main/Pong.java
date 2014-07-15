package Main;

import org.jbox2d.common.Vec2;

import Model.*;
import Model.Physics.PhysCircle;
import Model.Physics.PhysRect;
import Model.Physics.World;

public class Pong extends Game{
	
	Paddle paddleLeft;
	Paddle paddleRight;
	PhysCircle ball;
	World world;
	
	public Pong(){
		super(640,480);
		//paddleLeft = new Paddle(0,Screen.HEIGHT/2,10,100);
		//paddleRight = new Paddle(Screen.WIDTH-10,Screen.HEIGHT/2,10,100);
		//paddleLeft.setControls("W","S");
		world = new World(0);
		ball = world.createDynamicCircle(Screen.WIDTH/2, Screen.HEIGHT/2,Screen.toMeters(25));		
		ball.setVel(0.1, 5);
		ball.setLocation(1, 1);
		
		
		
		PhysRect wallTop = world.createStaticRect(0, 0, Screen.WIDTH, 0);
		wallTop.setRestitution(1.0f);
		PhysRect wallBottom = world.createStaticRect(0, Screen.HEIGHT, Screen.WIDTH, 1);
		wallBottom.setRestitution(1.0f);
		
		start();
	}
	
	
	
	public void update(){
		
		//paddleLeft.update();
		//paddleRight.update();
		
		world.update();
		ball.update();
		
	}
	
	
    public static void main(String args[]) {
    	Game game = new Pong();
    }
}
