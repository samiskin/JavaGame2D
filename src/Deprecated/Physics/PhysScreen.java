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


    private static void setUpMatrices() {

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glViewport(0, 0, WINDOW_DIMENSIONS[0], WINDOW_DIMENSIONS[1]);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        glOrtho(0, WINDOW_DIMENSIONS[0], 0, WINDOW_DIMENSIONS[1], 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);


    }


    public static double toMeters(int x) {
        // TODO Auto-generated method stub
        return 0;
    }

}
