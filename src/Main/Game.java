package Main;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JFrame;


class Game extends Engine{
	
	protected Window screen;
	
	public Game(int screenWidth, int screenHeight){
		screen = new Window (screenWidth,screenHeight, this);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		screen.start();
	}
	
	
	public void update(){
		
	}
	
	
	public static void main(String[] args)
	{
		Game game = new Game(1280,720);		
	}

}
