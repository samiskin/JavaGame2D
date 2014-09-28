package JavaGame.Input;

import JavaGame.Util.Vec;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.awt.event.MouseListener;

/**
 * Created by Shiranka Miskin on 2014-07-24.
 */
public class MouseEvent {


    public static int getX() {
        return Mouse.getX();
    }

    public static int getY() {
        return Mouse.getY();
    }

    public static Vec getLocation(){
        return new Vec(getX(),getY());
    }

    public static boolean getCtrlKey() {
        return Input.keyPressed(Keyboard.KEY_LCONTROL) || Input.keyPressed(Keyboard.KEY_RCONTROL);
    }

    public static boolean getShiftKey() {
        return Input.keyPressed(Keyboard.KEY_LSHIFT) || Input.keyPressed(Keyboard.KEY_RSHIFT);
    }

    public static boolean getAltKey() {
        return Input.keyPressed(Keyboard.KEY_LMENU) || Input.keyPressed(Keyboard.KEY_RMENU);
    }

    public static short getButton() {
        return (short) Mouse.getEventButton();
    }

}
