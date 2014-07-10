package View;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

public class Image {
	
	Texture texture;
	
	public Image(String path) throws IOException{
		texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
	}
	
	public Image(String path, String fileType) throws IOException{
		texture = TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream(path));
	}
	
	public void draw(int x, int y, int width, int height){
		texture.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(1, 0);
        glVertex2i(x+width, y);
        glTexCoord2f(0, 0);
        glVertex2i(x, y);
        glTexCoord2f(0, 1);
        glVertex2i(x, y+height);
        glTexCoord2f(1, 1);
        glVertex2i(x+width, y+height);
        glEnd();		
	}

}
