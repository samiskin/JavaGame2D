package JavaGame;

import java.awt.Color;

public class RectView extends ViewComponent{

	private Rect rect;
	
	public RectView (Rect target){
		rect = target;
	}
	
	public void render() {
		screen.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), rect.getAngle());		
	}
	
	
}
