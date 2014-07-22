package Pong;

import org.jbox2d.common.Vec2;
import org.lwjgl.input.Keyboard;

import JavaGame.Game;
import JavaGame.Screen;
import Physics.PhysCircle;
import Physics.PhysRect;
import Physics.World;

public class PongTest extends Game{
	
	Paddle paddleLeft;
	Paddle paddleRight;
	PhysCircle ball;
	World world;
	
	public PongTest(){
		super(1640,480);
	}
	
	public void init(){
		Screen.setPixelsPerMeter(30);
		world = new World(0);		
		world.enableWalls(true, false, true, false, Screen.WIDTH, Screen.HEIGHT,1);
		
		
		paddleLeft = new Paddle(0.15,Screen.getCenter().y,.3,2.5, world);
		
		
		paddleRight = new Paddle(Screen.WIDTH-0.15,Screen.getCenter().y,.3,2.5, world);
		paddleLeft.setControls(Keyboard.KEY_W,Keyboard.KEY_S);
		ball = world.createDynamicCircle(Screen.WIDTH/2, Screen.HEIGHT/2,Screen.toMeters(10));		
		ball.setVel(15,10);
		ball.setPosition(Screen.getCenter());
		ball.setRestitution(1);
		ball.setFriction(0);
		paddleRight.setFriction(0);
			
	}
	
	public void update(){

		paddleLeft.update();
		paddleRight.update();	
		ball.update();	
		world.update();
		System.out.println(ball.getLinearVelocity().length());
	}
	
	public void render(){
		paddleLeft.render();
		paddleRight.render();
		ball.render();		
	}
	
	
    public static void main(String args[]) {
    	Game game = new PongTest();
    }
}
