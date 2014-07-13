package Model;

import Main.Screen;
import Model.Generic.AbstractEntity2D;
import View.*;
import Controller.*;

public class Paddle extends AbstractEntity2D{

	private int width;
	private int height;
	private PaddleController control;
	private PaddleView view;
	
	private int speed = 5;
	
	public Paddle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;	
		control = new PaddleController(this);
		view = new PaddleView(this);
	}
	
	public void update(){
		control.update();
		view.update();
	}
	
	public void setControls(String up, String down){
		control.setKeyCommand("UP",up);
		control.setKeyCommand("DOWN",down);
	}
	
	public void moveUp(){
		if (y-speed > 0)
			y -= speed;
		else
			y = 0;
	}
	
	public void moveDown(){
		if (y+height+speed < Screen.HEIGHT)
			y += speed;
		else
			y = Screen.HEIGHT - height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	private boolean inRange(double num, double lower, double upper){
		return num >= lower && num < upper;
	}

	
	
}
