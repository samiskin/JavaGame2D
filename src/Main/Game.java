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
    
	static Screen screen;
	public static long timeDelta;
	private Image img;
	
	public Game(){
        screen = new Screen(1280,720);

        img = null;
        try {
			img = new Image("res/images/beserker.gif","GIF");
		} catch (IOException e) {
			e.printStackTrace();
		}        

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
            update();
            Display.update();
            Display.sync(60);
        }


        // Release the resources of the wood texture
        Display.destroy();
        System.exit(0);
	}
	
	protected void update(){
		img.draw(10,10,100,100);
		screen.drawOval(100, 100, 100, 100);
	}


}
