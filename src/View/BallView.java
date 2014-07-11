package View;

import java.awt.Color;

import Model.Ball;

public class BallView extends ViewComponent{

	Ball ball;
	
	public BallView(Ball target){
		ball = target;
	}
	

	public void update() {
		screen.fillOval(ball.getX(), ball.getY(), ball.getRadius(), Color.WHITE);
		
	}

}
