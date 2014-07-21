package JavaGame;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;

public class Input{
	
	public static HashMap<String,Integer> keys = new HashMap<String,Integer>();
	protected HashMap<String,Integer> cmd;
	
	public Input(){
		cmd = new HashMap<String,Integer>();
	}


	public static boolean keyPressed(int key){
		return Keyboard.isKeyDown(key);
	}
	
	public void setKeyCommand(String command, int key){
		cmd.put(command, key);
	}
	
	
	public void update(){
		
	}
	
}
