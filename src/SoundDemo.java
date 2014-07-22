import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import JavaGame.Game;
import JavaGame.Display.Screen;
import JavaGame.Sound.Sound;
import JavaGame.Util.Button;


public class SoundDemo extends Game{

	Sound testSound;
	ArrayList <Button> buttons;
	
	public SoundDemo() {
		super(200, 50);
	}

	protected void init() {	
		testSound = new Sound("res/audio/Electric Feel.mp3");
		testSound.loop();
		
		buttons = new ArrayList<Button>();
		for (int i = 0; i < 4; i++)
			buttons.add(new Button(i*50,0,50,50));
		System.out.println(buttons.size());
	}

	
	protected void update() {
		if (buttons.get(0).clicked()){
			testSound.pause();
		} else if (buttons.get(1).clicked()){
			testSound.resume();
		} else if (buttons.get(2).clicked())
			testSound.setVolume(0.1);
		else if (buttons.get(3).clicked())
			testSound.setVolume(1);
		
		
	}

	
	protected void render() {
		
		Screen.setColor(Color.red);
		Screen.fillRect(buttons.get(0));
		Screen.setColor(Color.green);
		Screen.fillRect(buttons.get(1));
		Screen.setColor(Color.orange);
		Screen.fillRect(buttons.get(2));
		Screen.setColor(Color.cyan);
		Screen.fillRect(buttons.get(3));
		
	}
	
	public static void main(String[] args){
		Game game = new SoundDemo();
	}

}
