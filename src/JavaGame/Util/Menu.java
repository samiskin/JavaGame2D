package JavaGame.Util;

import JavaGame.Display.Image;
import JavaGame.Display.Screen;
import org.newdawn.slick.Color;

import java.util.LinkedList;

public class Menu {

	public LinkedList<MenuLink> links;
    private Menu nextMenu;
	private boolean complete;
    public Image background;
	
	public Menu(Image background){
        complete =  false;
        this.background = background;
	}

    public Menu(){
        this(null);
    }
	

    public boolean isComplete(){
        return complete;
    }

    public Menu getNext(){
        return nextMenu;
    }

    public void update() {
        for (MenuLink link : links){
            if (link.clicked()){
                complete = true;
                nextMenu = link.next;
            }
        }
    }

    public void render() {
        if (background != null) {
            Screen.setColor(Color.white);
            Screen.fillRect(0,0,Screen.WIDTH,Screen.HEIGHT);
            background.render(0,0, Screen.WIDTH,Screen.HEIGHT);
        }
    }
    
    
    private class MenuLink extends Button{

    	private Menu next;
    	
		public MenuLink(double x, double y, double width, double height, Menu nextMenu) {
			super(x, y, width, height);
			next = nextMenu;			
		}
    	
    }
	
}
