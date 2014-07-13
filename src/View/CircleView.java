package View;

import java.awt.Color;

import Model.Generic.Circle;

public class CircleView extends ViewComponent{

	private Circle circle;
	
	public CircleView (Circle target){
		circle = target;
	}
	
	public void update() {
		screen.fillOval(circle.getX(), circle.getY(), circle.getRadius(), Color.WHITE);		
	}

}
