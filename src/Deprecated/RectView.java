package Deprecated;

import java.awt.Color;

import JavaGame.Screen;

public class RectView extends ViewComponent{

	private Rect rect;
	
	public RectView (Rect target){
		rect = target;
	}
	
	public void render() {
		Screen.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), rect.getAngle());		
	}
	
	
}
