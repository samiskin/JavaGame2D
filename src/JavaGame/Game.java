package JavaGame;

import JavaGame.Display.Screen;
import JavaGame.Input.Input;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

public abstract class Game {

    public static int MAX_FPS = 60;
    static Screen screen;
    private boolean end;

    protected Game(int width, int height) {
        screen = new Screen(width, height);
        init();
        start();
    }

    protected void setFPS(int fps) {
        MAX_FPS = fps;
    }

    protected void start() {

        while (!Display.isCloseRequested() && !end) {
            glClear(GL_COLOR_BUFFER_BIT);
            Screen.render();
            Input.update();
            update();
            render();
            Display.update();
            Display.sync(MAX_FPS);
        }


        // Release the resources of the wood texture
        Display.destroy();
        System.exit(0);
    }

    protected void end() {
        end = true;
    }

    protected abstract void init();

    protected abstract void update();

    protected abstract void render();


}
