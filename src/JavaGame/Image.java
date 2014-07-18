package JavaGame;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

public class Image {
	
	Texture texture;
	
	public Image(String path){
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image(String path, String fileType){
		try {
			texture = TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(double x,double y,double width,double height){
		
		x = Screen.toPixels(x);
		y = Screen.toPixels(y);
		width = Screen.toPixels(width);
		height = Screen.toPixels(height);
        glEnable(GL_TEXTURE_2D);
		glColor3f(1f,1f,1f);
		texture.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(1, 0);
        glVertex2d(x+width, y);
        glTexCoord2f(0, 0);
        glVertex2d(x, y);
        glTexCoord2f(0, 1);
        glVertex2d(x, y+height);
        glTexCoord2f(1, 1);
        glVertex2d(x+width, y+height);
        glEnd();		
        glDisable(GL_TEXTURE_2D);
	}
	

}
