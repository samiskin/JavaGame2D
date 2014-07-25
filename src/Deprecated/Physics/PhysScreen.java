package Deprecated.Physics;

import JavaGame.Display.Screen;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class PhysScreen extends Screen {

    private static final int[] WINDOW_DIMENSIONS = null;


    public PhysScreen(int width, int height) {
        super(width, height);
    }


    public static void fillRect(double x, double y, double width, double height, double angle) {
        width = toPixels(width);
        height = toPixels(height);
        x = toPixels(x);
        y = toPixels(y);
        glPushMatrix();
        glTranslated(x, y, 0);
        glRotated(Math.toDegrees(angle), 0, 0, 1);
        glRectd(-width / 2, -height / 2, width / 2, height / 2);
        glPopMatrix();
    }

    public static double toPixels(double y) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static void setPixelsPerMeter(double ppm) {

    }


    public static double toMeters(int x) {
        // TODO Auto-generated method stub
        return 0;
    }

}
