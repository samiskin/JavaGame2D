package JavaGame;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public abstract class Game {
    
	static Screen screen;
	public static long timeDelta;
	private Image img;
	public static int MAX_FPS = 60;
	
	public Game(int width, int height){
        screen = new Screen(width,height);        
        InputComponent.init();
        init();
        start();
    }
	
	public void start(){
        
        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
    		screen.render();		
            update();
            render();
            Display.update();
            Display.sync(MAX_FPS);
        }
        


        // Release the resources of the wood texture
        Display.destroy();
        System.exit(0);		
	}
	
	protected abstract void init();
	
	protected abstract void update();
	
	protected abstract void render();


}
