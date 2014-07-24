package JavaGame.Input;

import org.lwjgl.input.Keyboard;

public class Input {


    public static boolean keyPressed(int key) {
        return Keyboard.isKeyDown(key);
    }

    public static void update() {
        MouseBroadcaster.update();
    }

}
