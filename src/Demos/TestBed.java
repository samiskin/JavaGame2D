package Demos;

import JavaGame.Game;
import JavaGame.Util.*;
import JavaGame.Output.*;
import JavaGame.Input.*;



public class TestBed extends Game {

    private Menu menu;
    private Image test;

    public TestBed() {
        super(120, 120);
		init();
		start();
    }

	public void update()
	{
		render();
	}

    protected void init() {
        menu = new Menu(new Image("res/images/Map.jpg","jpg"));
        test = new Image("res/images/moon.png");

    }


    protected void render() {
        menu.render();
        test.render(Input.getX()-50,Input.getY()-50,100,100);


    }

}
