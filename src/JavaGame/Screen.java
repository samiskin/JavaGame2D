package JavaGame;
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
import java.io.InputStream;
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
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;


public class Screen extends JFrame{

	
	public static double WIDTH, HEIGHT;
	
	public static long lastFrameMS; 
	public static int fps;
	public static long lastFPS;
	
	public static double PIXELS_PER_METER;
	public static int[] WINDOW_DIMENSIONS;
	
	private static UnicodeFont font;
	
	public Screen (int width, int height)
	{
		WINDOW_DIMENSIONS = new int[2];
		WINDOW_DIMENSIONS[0] = width;
		WINDOW_DIMENSIONS[1] = height;
        setUpDisplay();
        setUpMatrices();

        font = this.initCustomFont("res/fonts/SwordArtOnline.ttf", 20f);
        
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

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);        
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);                    
 
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                
        GL11.glClearDepth(1);                                       
 
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        GL11.glViewport(0,0,WINDOW_DIMENSIONS[0],WINDOW_DIMENSIONS[1]);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
        glOrtho(0, WINDOW_DIMENSIONS[0], 0,WINDOW_DIMENSIONS[1], 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

     
    }
	
	public static void render(){
		updateFPS();
	}
	
	public static void setColor(Color c)
	{		
		setColor(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public static void setColor(Color c, int a)
	{		
		setColor(c.getRed(), c.getGreen(), c.getBlue(), a);
	}
	
	public static void setColor(int r, int g, int b, int a){
		glColor4f(r/255f,g/255f,b/255f,a/255f);
	}
	
	public static void setColor(int r, int g, int b){
		setColor(r,g,b,255);
	}
	
	public static void setColor(int hex){
		setColor((hex >> 16) & 0xFF, (hex >> 8) & 0xFF, hex & 0xFF);
	}
	
	public static void setBGColor(Color c){
    	glClearColor(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public static void fillRect (double x, double y, double width, double height, double angle)
	{
		width = toPixels(width);
		height = toPixels(height);
		x = toPixels(x);
		y = toPixels(y);
		glPushMatrix();
		glTranslated(x,y,0);
		glRotated(Math.toDegrees(angle),0,0,1);
		glRectd(-width/2,-height/2,width/2,height/2); 
		glPopMatrix();
	}
	
	public static void fillRect(double x, double y, double width, double height){
		fillRect(x,y,width,height,0);
	}
	
	public static void drawCircle(double cx, double cy, double r, int num_segments) 
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
	
	public static void drawCircle(double cx, double cy, double r){
		drawCircle(cx,cy,r,(int)(Math.max(r/2,15)));
	}
	
	public static void fillCircle(double cx, double cy, double r, int num_segments) 
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
	
	public static void fillOval(double cx, double cy, double r){
		fillCircle(cx,cy,r,(int)(Math.max(r/2,15)));
	}
	
	public static void drawLine(double x1, double y1, double x2, double y2){
		glBegin(GL_LINES);
		glVertex2d(x1,y1);
		glVertex2d(x2,y2);
		glEnd();
	}
	
	public static void drawLine(Vec p1, Vec p2){
		drawLine(p1.x,p1.y,p2.x,p2.y);
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
    
    
    public static void drawText(){    	
     
    	// load font from a .ttf file
    	/*try {
    		InputStream inputStream	= ResourceLoader.getResourceAsStream("myfont.ttf");
     
    		Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
    		awtFont2 = awtFont2.deriveFont(24f); // set font size
    		font2 = new TrueTypeFont(awtFont2, false);
     
    	} catch (Exception e) {
    		e.printStackTrace();
    	}	*/
    	if (font == null)
            font = initCustomFont("res/fonts/SwordArtOnline.ttf", 20f);
		Color.white.bind();
    	font.drawString(100, 50, "THE LIGHTWEIGHT JAVA GAMES LIBRARY");
    }
    
    
   	private static UnicodeFont initAwtFont(String font, int style, float size){
   		Font awtFont = new Font(font, style, 1);
   		return initFont(awtFont,size);
   	}
   	
   	private static UnicodeFont initCustomFont(String path, float size){
   		InputStream iStream = ResourceLoader.getResourceAsStream(path);
   		Font awtFont = null;
   		try {
			awtFont = Font.createFont(Font.TRUETYPE_FONT, iStream);
			
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
   		return initFont(awtFont,size);
   	}
   	
   	
   	private static UnicodeFont initFont(Font font, float size){
   		UnicodeFont f = new UnicodeFont(font.deriveFont(0 /*normal*/, size));
   		f.addAsciiGlyphs();
   		ColorEffect e = new ColorEffect();
   		e.setColor(java.awt.Color.white);
   		f.getEffects().add(e);
   		try {
   		    f.loadGlyphs();
   		} catch (SlickException e1) {
   		    e1.printStackTrace();
   		}
   		return f;
   	}
    
    
    
    
    
}
