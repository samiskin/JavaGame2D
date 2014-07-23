package JavaGame.Geom;

import JavaGame.Util.Vec;

public class Rect {

    public double x, y, width, height;

    public Rect(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setSize(Vec dim) {
        setSize(dim.x, dim.y);
    }

    public Vec getPosition() {
        return new Vec(x, y);
    }

    public void setPosition(Vec v) {
        setPosition(v.x, v.y);
    }

    public boolean inBounds(double x2, double y2) {
        return x2 >= x && x2 <= x + width && y2 >= y && y2 <= y + width;
    }

    public boolean inBounds(Vec v) {
        return inBounds(v.x, v.y);
    }

}
