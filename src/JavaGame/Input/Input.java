package JavaGame.Input;

import JavaGame.Output.Screen;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {


    public static boolean keyPressed(int key) {
        return Keyboard.isKeyDown(key);
    }

    public static void update() {
        MouseBroadcaster.update();
    }


    public static double getX(){
        return Mouse.getX();
    }

    public static double getY(){
        return Screen.HEIGHT-Mouse.getY();
    }

}
