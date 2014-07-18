package Main.Pong;

import org.jbox2d.common.Vec2;

import JavaGame.Game;
import JavaGame.PhysCircle;
import JavaGame.PhysRect;
import JavaGame.Screen;
import JavaGame.World;

public class PongTest extends Game{
	
	Paddle paddleLeft;
	Paddle paddleRight;
	PhysCircle ball;
	World world;
	
	public PongTest(){
		super(480,480);
		Screen.setPixelsPerMeter(30);
		world = new World(0);
		
		world.enableWalls(true, false, true, false, Screen.WIDTH, Screen.HEIGHT,1);
		
		
		paddleLeft = new Paddle(.05,Screen.getCenter().y,.1,1, world);
		paddleRight = new Paddle(Screen.HEIGHT-0.05,Screen.getCenter().y,.1,1, world);
		paddleLeft.setControls("W","S");
		ball = world.createDynamicCircle(Screen.WIDTH/2, Screen.HEIGHT/2,Screen.toMeters(25));		
		ball.setVel(0.1, 5);
		ball.setPosition(Screen.getCenter());
		
		
		
		PhysRect wallTop = world.createStaticRect(0, 0, Screen.WIDTH, 0);
		wallTop.setRestitution(1.0f);
		PhysRect wallBottom = world.createStaticRect(0, Screen.HEIGHT, Screen.WIDTH, 1);
		wallBottom.setRestitution(1.0f);
		
		start();
	}
	
	
	
	public void update(){
		
		paddleLeft.update();
		paddleRight.update();		
		world.update();
		ball.update();
		
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
