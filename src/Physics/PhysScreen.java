package Physics;

import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRectd;
import static org.lwjgl.opengl.GL11.glRotated;
import static org.lwjgl.opengl.GL11.glTranslated;

import org.lwjgl.opengl.GL11;

import JavaGame.Screen;

public class PhysScreen extends Screen{

	public PhysScreen(int width, int height) {
		super(width, height);
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
        glOrtho(0, WINDOW_DIMENSIONS[0],0, WINDOW_DIMENSIONS[1], 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

     
    }

}
