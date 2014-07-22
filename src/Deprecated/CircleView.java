package Deprecated;

import java.awt.Color;

import JavaGame.Display.Screen;

public class CircleView extends ViewComponent{

	private Circle circle;
	
	public CircleView (Circle target){
		circle = target;
	}
	
	public void render() {
		Screen.fillOval(circle.getX(), circle.getY(), circle.getRadius());		
	}

}
