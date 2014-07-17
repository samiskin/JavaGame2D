package Main;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotated;
import static org.lwjgl.opengl.GL11.glTranslatef;

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

import org.jbox2d.common.Vec2;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import Model.Generic.Vec;
import Model.Physics.World;
import View.ViewComponent;
import static org.lwjgl.opengl.GL11.*;


public class Screen extends JFrame{

	
	public static double WIDTH, HEIGHT;
	
	public static long lastFrameMS; 
	public static int fps;
	public static long lastFPS;
	
	public static double PIXELS_PER_METER;
	public static int[] WINDOW_DIMENSIONS;
	
	public Screen (int width, int height)
	{
		WINDOW_DIMENSIONS = new int[2];
		WINDOW_DIMENSIONS[0] = width;
		WINDOW_DIMENSIONS[1] = height;
        setUpDisplay();
        setUpMatrices();
        PIXELS_PER_METER = 1;
		        
        ViewComponent.init(this);
		WIDTH = (double)(width)/PIXELS_PER_METER;
		HEIGHT = (double)(height)/PIXELS_PER_METER;
		lastFPS = getTime();
	}
	
    private static void setUpDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(WINDOW_DIMENSIONS[0], WINDOW_DIMENSIONS[1]));
            Display.setTitle("Game");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            cleanUp(true);
        }
    }
    
    private static void setUpMatrices(){
    	glClearColor(0.0f,0.0f,0.0f,1.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WINDOW_DIMENSIONS[0], 0,WINDOW_DIMENSIONS[1], 1, -1);
        glMatrixMode(GL_MODELVIEW);  
        glEnable(GL_BLEND); 
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        
    }
	
	public static void update(){
		updateFPS();
	}
	
	public static void setColor(Color c)
	{		
		glColor4f(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
		
	public static void fillRect (double x, double y, double width, double height, double angle, Color c)
	{
		width = toPixels(width);
		height = toPixels(height);
		x = toPixels(x);
		y = toPixels(y);
		setColor(c);
		glPushMatrix();
		glTranslated(x,y,0);
		glRotated(Math.toDegrees(angle),0,0,1);
		glRectd(-width/2,-height/2,width/2,height/2); 
		glPopMatrix();
	}
	
	public static void fillRect(double x, double y, double width, double height, Color c){
		fillRect(x,y,width,height,0,c);
	}
	
	public static void drawOval(double cx, double cy, double r, Color color, int num_segments) 
	{ 
		cx *= PIXELS_PER_METER;
		cy *= PIXELS_PER_METER;
		r *= PIXELS_PER_METER;
		
		
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
	
	public static void drawOval(double cx, double cy, double r, Color color){
		drawOval(cx,cy,r,color,(int)(Math.max(r/2,15)));
	}
	
	public static void fillOval(double cx, double cy, double r, Color color, int num_segments) 
	{ 
		cx *= PIXELS_PER_METER;
		cy *= PIXELS_PER_METER;
		r *= PIXELS_PER_METER;
		
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
	
	public static void fillOval(double cx, double cy, double r, Color color){
		fillOval(cx,cy,r,color,(int)(Math.max(r/2,15)));
	}
	
	public static int toPixels(double meters){
		return (int)(meters*PIXELS_PER_METER);
	}
	
	public static double toMeters(double pixels){
		return pixels/PIXELS_PER_METER;
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
	
    private static void cleanUp(boolean asCrash) {
        Display.destroy();
        System.exit(asCrash ? 1 : 0);
    }
    
    public static void setPixelsPerMeter(double ppm){
    	PIXELS_PER_METER = ppm;
		WIDTH = (double)(WINDOW_DIMENSIONS[0])/PIXELS_PER_METER;
		HEIGHT = (double)(WINDOW_DIMENSIONS[1])/PIXELS_PER_METER;
    }
    
    public static Vec2 getCenter(){
		return new Vec(WIDTH/2,HEIGHT/2);
    }
}
