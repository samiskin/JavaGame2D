package Main.Pong;

import JavaGame.AbstractEntity2D;
import JavaGame.Screen;
import Physics.PhysRect;
import Physics.World;

public class Paddle extends PhysRect{

	private int width;
	private int height;
	private PaddleController control;
	
	private int speed = 10;
	
	public Paddle(double x, double y, double width, double height, World world){
		super(world.createDynamicRect(x, y, width, height));
		body.setFixedRotation(true);
		this.setRestitution(1);
		this.setFriction(0);
		control = new PaddleController(this);
	}
	
	public void update(){
		control.update();
	}
	
	public void setControls(int up, int down){
		control.setKeyCommand("UP",up);
		control.setKeyCommand("DOWN",down);
	}
	
	public void moveUp(){
		setVel(0, speed);
	}
	
	public void moveDown(){
		setVel(0,-speed);
	}
	
	public void noInput(){
		setVel(0,0);
		this.body.setSleepingAllowed(true);
	}
	
	
}
