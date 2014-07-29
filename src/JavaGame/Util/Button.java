package JavaGame.Util;

import JavaGame.Input.MouseEvent;
import JavaGame.Input.MouseObserver;
import org.lwjgl.input.Mouse;


public class Button extends Rect implements MouseObserver{

    private int clickCount;

    public Button(double x, double y, double width, double height) {
        super(x, y, width, height);

    }

    // Currently clicked
    public boolean click() {
        return Mouse.isButtonDown(0) && inBounds(Mouse.getX(), Mouse.getY());
    }

    // Was clicked
    public boolean clicked(){
        return clickCount > 0;
    }


    public void notify(MouseEvent e) {
        if (inBounds(e.getX(),e.getY()))
            clickCount++;
    }
}
