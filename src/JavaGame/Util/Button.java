package JavaGame.Util;

import org.lwjgl.input.Mouse;

import JavaGame.Geom.Rect;


public class Button extends Rect{

	
	
	public Button(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	public boolean clicked(){		
		return Mouse.isButtonDown(0) && inBounds(Mouse.getX(),Mouse.getY());
	}
	
	
}
