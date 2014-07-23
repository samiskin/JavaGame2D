package Demos;

import JavaGame.Display.Font;
import JavaGame.Display.Screen;
import JavaGame.Game;
import org.newdawn.slick.Color;


public class TestBed extends Game {

    private Font font;
    private double angle;


    public TestBed() {
        super(200, 50);
    }

    protected void init() {
        font = new Font("res/fonts/SwordArtOnline.ttf", 25);
        angle = 0;
    }

    protected void update() {


    }

    protected void render() {
        angle++;
        Screen.setColor(Color.white);
        //Screen.setColor(Color.blue);
        Screen.drawString(font, "Hello there test", 10, 10, angle % 360);
        //Screen.fillRect(10,10,126,28,angle%360);
    }

}
