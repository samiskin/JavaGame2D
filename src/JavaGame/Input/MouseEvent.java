package JavaGame.Input;

import JavaGame.Util.Vec;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.awt.event.MouseListener;

/**
 * Created by Shiranka Miskin on 2014-07-24.
 */
public class MouseEvent {


    public int getX() {
        return Mouse.getX();
    }

    public int getY() {
        return Mouse.getY();
    }

    public Vec getLocation(){
        return new Vec(getX(),getY());
    }

    public boolean getCtrlKey() {
        return Input.keyPressed(Keyboard.KEY_LCONTROL) || Input.keyPressed(Keyboard.KEY_RCONTROL);
    }

    public boolean getShiftKey() {
        return Input.keyPressed(Keyboard.KEY_LSHIFT) || Input.keyPressed(Keyboard.KEY_RSHIFT);
    }

    public boolean getAltKey() {
        return Input.keyPressed(Keyboard.KEY_LMENU) || Input.keyPressed(Keyboard.KEY_RMENU);
    }

    public short getButton() {
        return (short) Mouse.getEventButton();
    }

}
