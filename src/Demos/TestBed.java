package Demos;

import JavaGame.Display.Image;
import JavaGame.Display.Screen;
import JavaGame.Game;
import JavaGame.Input.Input;
import JavaGame.Util.Menu;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;


public class TestBed extends Game {

    private Menu menu;
    private Image test;

    public TestBed() {
        super(1280, 640);
    }

    protected void init() {
        menu = new Menu(new Image("res/images/Map.jpg","jpg"));
        test = new Image("res/images/moon.png");

    }

    protected void update() {

    }

    protected void render() {
        menu.render();
        test.render(Mouse.getX()-50,Mouse.getY()-50);

    }

}
