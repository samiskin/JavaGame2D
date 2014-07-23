package Deprecated;

import JavaGame.Display.Screen;

public class RectView extends ViewComponent {

    private Rect rect;

    public RectView(Rect target) {
        rect = target;
    }

    public void render() {
        Screen.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), rect.getAngle());
    }


}
