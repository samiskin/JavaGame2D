package JavaGame;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import JavaGame.Display.Screen;
import JavaGame.Util.Vec;

public class Input{
	
	

	public static boolean keyPressed(int key){
		return Keyboard.isKeyDown(key);
	}
	
	public static void update(){
		
	}
	
}
