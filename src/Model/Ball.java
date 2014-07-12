package Model;

import Main.Screen;
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
	
	public void bounceX(){
		velX *= -1;
	}
	
	public void bounceY(){
		velY *= -1;
	}
	
	public void update(){
		view.update();		
		if (y-radius < 0 || y+radius > Screen.HEIGHT)
			bounceY();
		if (x-radius < 0 || x+radius > Screen.WIDTH)
			bounceX();
			
		y += velY;
		x += velX;
		
	}
	
	public int getRadius(){
		return radius;
	}
}
