package View;

import java.awt.Color;

import Model.Generic.Rect;

public class RectView extends ViewComponent{

	private Rect rect;
	
	public RectView (Rect target){
		rect = target;
	}
	
	public void update() {
		System.out.println(rect.getX() + ", " + rect.getY()+ " : " + rect.getWidth() + ", " + rect.getHeight());
		screen.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), Color.white);		
	}
	
	
}
