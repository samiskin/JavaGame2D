package Model;

import Main.Screen;
import View.*;
import Controller.*;

public class Paddle extends AbstractEntity2D{

	private int width;
	private int height;
	private InputComponent control;
	private ViewComponent view;
	
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
	
	public void moveUp(){
		if (y+height < Screen.HEIGHT)
			y += speed;
	}
	
	public void moveDown(){
		if (y > 0)
			y -= speed;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	
}
