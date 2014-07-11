package Model;

import View.BallView;
import View.ViewComponent;

public class Ball extends AbstractEntity2D{
	
	private int radius;
	private ViewComponent view;
	private double velX;
	private double velY;
	
	public Ball(int x, int y, int radius){
		this.radius = radius;
		this.x = x;
		this.y = y;
		velX = 5;
		velY = 5;
		view = new BallView(this);
	}
	
	public void setVel(int velX, int velY){
		this.velX = velX;
		this.velY = velY;
	}
	
	public void update(){
		view.update();
		x += velX;
		y += velY;
	}
	
	public int getRadius(){
		return radius;
	}
}
