package JavaGame.Display;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Image {

    protected Texture texture;

    public Image(String path) {
        this(path,"PNG");
    }

    public Image(String path, String fileType) {
        try {
            texture = TextureLoader.getTexture(fileType, ResourceLoader.getResourceAsStream(path));
            glDisable(GL_TEXTURE_2D); // For some reason this is necessary to draw shapes
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(double x, double y, double width, double height) {
        System.out.println(width + ", " + height);
        Screen.drawImage(this,x,y,width,height);
    }

    public int getWidth(){
        return texture.getImageWidth();
    }

    public int getHeight(){
        return texture.getImageHeight();
    }

    public void render(double x, double y){
        render(x, y, getWidth(),getHeight());
    }


}
