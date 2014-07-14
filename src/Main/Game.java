package Main;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import Controller.InputComponent;
import Model.File.FileReader;
import Model.File.FileWriter;
import Model.Physics.Physics;
import View.Image;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Game {
    
	static Screen screen;
	public static long timeDelta;
	private Image img;
	
	public Game(int width, int height){
        screen = new Screen(width,height);
        InputComponent.init();
        Physics.init(Screen.world);

	
	}
	
	public void start(){
        
        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
    		screen.update();		
            update();
            Display.update();
            Display.sync(60);
        }
        


        // Release the resources of the wood texture
        Display.destroy();
        System.exit(0);		
	}
	
	protected void update(){
	}


}
