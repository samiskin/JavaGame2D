package JavaGame;

import java.awt.Color;

public class CircleView extends ViewComponent{

	private Circle circle;
	
	public CircleView (Circle target){
		circle = target;
	}
	
	public void render() {
		screen.fillOval(circle.getX(), circle.getY(), circle.getRadius());		
	}

}
