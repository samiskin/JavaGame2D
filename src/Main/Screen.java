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
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import View.ViewComponent;
import static org.lwjgl.opengl.GL11.*;


public class Screen extends JFrame{

	
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	
	public static long lastFrameMS; 
	public static int fps;
	public static long lastFPS;
	
	public Screen (int width, int height)
	{
		try {
            Display.setDisplayMode(new DisplayMode(width, height));
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
        
        
        ViewComponent.init(this);
		WIDTH = width;
		HEIGHT = height;	
		lastFPS = getTime();
	}
	
	public void update(){
		updateFPS();
	}
	
	public void setColor(Color c)
	{		
		glColor4f(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
		
	public void fillRect (int x, int y, int width, int height, Color c)
	{
		setColor(c);
		glBegin(GL_QUADS);		 
			glVertex2f(x,y);
			glVertex2f(x+width,y);
			glVertex2f(x+width,y+height);
			glVertex2f(x,y+height);		 
		glEnd();	   	
	}
	
	public void drawOval(double cx, double cy, double r, Color color, int num_segments) 
	{ 
		double theta = 2 * 3.1415926 / num_segments; 
		double c = Math.cos(theta);//precalculate the sine and cosine
		double s = Math.sin(theta);
		double t;

		double x = r;//we start at angle = 0 
		double y = 0; 

		setColor(color);
	    glBegin(GL_LINE_LOOP); 
	    for(int ii = 0; ii < num_segments; ii++) 
	    { 
	        glVertex2d(x + cx, y + cy);//output vertex 

	        //apply the rotation matrix
	        t = x;
	        x = c * x - s * y;
	        y = s * t + c * y;
	    } 
	    glEnd(); 
	}
	
	public void drawOval(double cx, double cy, double r, Color color){
		drawOval(cx,cy,r,color,(int)(Math.max(r/2,15)));
	}
	
	public void fillOval(double cx, double cy, double r, Color color, int num_segments) 
	{ 
		double theta = 2 * 3.1415926 / num_segments; 
		double c = Math.cos(theta);//precalculate the sine and cosine
		double s = Math.sin(theta);
		double t;

		double x = r;//we start at angle = 0 
		double y = 0; 

		setColor(color);
	    glBegin(GL_TRIANGLE_FAN); 
	    for(int ii = 0; ii < num_segments; ii++) 
	    { 
	        glVertex2d(x + cx, y + cy);//output vertex 

	        //apply the rotation matrix
	        t = x;
	        x = c * x - s * y;
	        y = s * t + c * y;
	    } 
	    glEnd(); 
	}
	
	public void fillOval(double cx, double cy, double r, Color color){
		fillOval(cx,cy,r,color,(int)(Math.max(r/2,15)));
	}
	
	public static void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	public static int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrameMS);
	    lastFrameMS = time; 
	    return delta;
	}
	public static long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
}
