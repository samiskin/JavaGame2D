package View;

import Main.Screen;


public abstract class ViewComponent {
	
	protected static Screen screen;
	
	public static void init(Screen screen){
		ViewComponent.screen = screen;
	}
	public abstract void update();
}