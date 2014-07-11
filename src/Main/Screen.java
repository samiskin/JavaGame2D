package Main;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;


public class Screen extends JFrame{

	
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	
	public Screen (int width, int height)
	{
		try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setFullscreen(true);
            Display.setTitle("LWJGL Demo");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
		
		glClearColor(0.0f,0.0f,0.0f,1.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, 1, -1);
        //glMatrixMode(GL_MODELVIEW);
        
        
		WIDTH = width;
		HEIGHT = height;
		
	}

	
	
	public void drawOval (int x, int y, int width, int height)
	{

        glEnable(GL_COLOR_MATERIAL);
		Color c = Color.GREEN;

		int red    = c.getRed();
		int blue   = c.getBlue();
		int green  = c.getGreen();
		int alpha  = c.getAlpha();

		glColor4f(red, green, blue, alpha);

		   glBegin(GL_QUADS);
		 
		   	glVertex2f(100,100);
		   	glVertex2f(200,100);
		   	glVertex2f(200,200);
		   	glVertex2f(100,200);
		 
		   	glEnd();
	}
	
	
	
	
}
