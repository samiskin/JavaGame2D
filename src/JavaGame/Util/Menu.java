package JavaGame.Util;

import java.util.LinkedList;

public class Menu {

	public LinkedList<MenuLink> links;
	
	
	public Menu(){	
	}
	
	
    public void update() {
    	
    }

    public void render() {

    }
    
    
    private class MenuLink extends Button{

    	private Menu next;
    	
		public MenuLink(double x, double y, double width, double height, Menu nextMenu) {
			super(x, y, width, height);
			next = nextMenu;			
		}
		
		
    	
    	
    }
	
}
