package JavaGame.Display;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotated;
import static org.lwjgl.opengl.GL11.glTranslated;

import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

import JavaGame.Util.Vec;

public class Font {
	private UnicodeFont font;
	
	public Font(String path, float size){
		font = initCustomFont(path,size);		
	}
	
	public Font(String awtFont, int style, double size){
		initAwtFont(awtFont,style,size);
	}
	
	public Font(java.awt.Font awtFont, double size){
		initFont(awtFont,size);
	}
	
    
    public void drawText(double x, double y, String text, double angle){
    	Vec center = new Vec(font.getWidth(text)/2,font.getHeight(text)/2);
    	System.out.println(center);
		glPushMatrix();
		glTranslated(x+center.x,y+center.y,0);
		glRotated(angle,0,0,1);
    	font.drawString(-center.x,-center.y, text); 
		glPopMatrix();

		Screen.setColor(Color.WHITE);
    	Screen.fillOval(x, y, 4);
    	Screen.fillOval(x+center.x, y+center.y, 5);
    }
    
    public void drawText(double x, double y, String text){
    	drawText(x,y,text,0);
    }
    
	
   	private static UnicodeFont initAwtFont(String font, int style, double size){
   		java.awt.Font awtFont = new java.awt.Font(font, style, 1);
   		return initFont(awtFont,size);
   	}
   	
   	private static UnicodeFont initCustomFont(String path, double size){
   		InputStream iStream = ResourceLoader.getResourceAsStream(path);
   		java.awt.Font awtFont = null;
   		try {
			awtFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, iStream);
			
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
   		return initFont(awtFont,size);
   	}
   	
   	
   	private static UnicodeFont initFont(java.awt.Font font, double size){
   		UnicodeFont f = new UnicodeFont(font.deriveFont(0 /*normal*/, (float) size));
   		f.addAsciiGlyphs();
   		ColorEffect e = new ColorEffect();
   		e.setColor(Color.white);
   		f.getEffects().add(e);
   		try {
   		    f.loadGlyphs();
   		} catch (SlickException e1) {
   		    e1.printStackTrace();
   		}
   		return f;
   	}
    
    
	
	
}
