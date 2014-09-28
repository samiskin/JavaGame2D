package JavaGame;

import JavaGame.Output.Screen;
import JavaGame.Input.Input;
import org.lwjgl.opengl.Display;

public abstract class Game {

    public static int MAX_FPS = 60;
    static Screen screen;
    private boolean end;

    protected Game(int width, int height) {
        screen = new Screen(width, height);
    }

    protected void setFPS(int fps) {
        MAX_FPS = fps;
    }

    protected void start() {

        while (!Display.isCloseRequested() && !end) {
            Screen.render();
            Input.update();
            update();
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

    protected abstract void update();


}
