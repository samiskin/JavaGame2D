package Main;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import View.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

 
/**
 * If this application shows a blank and responsive window
 * and doesn't throw any errors, you know you have installed lwjgl
 * correctly.
 * @author Oskar Veerhoek
 */
public class Game {
    
	static Window screen;
	private static Texture wood;

    public static void main(String args[]) {
        screen = new Window(1280,720);

        Image img = null;
        try {
			img = new Image("res/images/wood.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
        

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
            img.draw(10,10,500,400);
            Display.update();
            Display.sync(60);
        }
        // Release the resources of the wood texture
        wood.release();
        Display.destroy();
        System.exit(0);
    }
}

/*import java.awt.Color;
import java.awt.Font;
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
		screen.drawOval(100, 100, 100, 100);
	}
	
	
	public static void main(String[] args)
	{
		Game game = new Game(1280,720);		
	}

}
*/