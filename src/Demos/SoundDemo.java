package Demos;

import java.util.ArrayList;

import JavaGame.Output.Screen;
import JavaGame.Game;
import JavaGame.Output.Sound;
import JavaGame.Util.Button;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;



public class SoundDemo extends Game {

    private Sound testSound;
    private ArrayList<Button> buttons;

    public SoundDemo() {
        super(200, 50);
    }


    protected void init() {
        testSound = new Sound("res/audio/Electric Feel.mp3");
        //testSound = new Sound("res/audio/blink.wav");
        testSound.loop();

        buttons = new ArrayList<Button>();
        for (int i = 0; i < 4; i++)
            buttons.add(new Button(i * 50, 0, 50, 50));
    }

    protected void update() {
        if (buttons.get(0).click()) {
            testSound.pause();
        } else if (buttons.get(1).click()) {
            testSound.resume();
        } else if (buttons.get(2).click())
            testSound.setVolume(0.1);
        else if (buttons.get(3).click())
            testSound.seek(4);
        else if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
            testSound.loop();
        testSound.update();

    }

    protected void render() {

        Screen.setColor(Color.red);
        Screen.fillRect(buttons.get(0).x,buttons.get(0).y,buttons.get(0).width,buttons.get(0).height);
        Screen.setColor(Color.green);
        Screen.fillRect(buttons.get(1).x,buttons.get(1).y,buttons.get(1).width,buttons.get(1).height);
        Screen.setColor(Color.orange);
        Screen.fillRect(buttons.get(2).x,buttons.get(2).y,buttons.get(2).width,buttons.get(2).height);
        Screen.setColor(Color.cyan);
        Screen.fillRect(buttons.get(3).x,buttons.get(3).y,buttons.get(3).width,buttons.get(3).height);

    }

}
