package Main.Pong;

import JavaGame.AbstractEntity2D;
import JavaGame.PhysRect;
import JavaGame.Screen;
import JavaGame.World;

public class Paddle extends PhysRect{

	private int width;
	private int height;
	private PaddleController control;
	
	private int speed = 5;
	
	public Paddle(double x, double y, double width, double height, World world){
		super(world.createDynamicRect(x, y, width, height));
		control = new PaddleController(this);
	}
	
	public void update(){
		control.update();
	}
	
	public void setControls(String up, String down){
		control.setKeyCommand("UP",up);
		control.setKeyCommand("DOWN",down);
	}
	
	public void moveUp(){
		setVel(0, speed);
	}
	
	public void moveDown(){
		setVel(0,-speed);
	}
	
	
	
}
