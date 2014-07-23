package Deprecated;

import JavaGame.Display.Screen;

public class CircleView extends ViewComponent {

    private Circle circle;

    public CircleView(Circle target) {
        circle = target;
    }

    public void render() {
        Screen.fillCircle(circle.getX(), circle.getY(), circle.getRadius());
    }

}
