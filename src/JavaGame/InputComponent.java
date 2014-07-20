package JavaGame;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;

public class InputComponent{
	
	public static HashMap<String,Integer> keys = new HashMap<String,Integer>();
	protected HashMap<String,String> cmd;
	
	public InputComponent(){
		cmd = new HashMap<String,String>();
	}
	
	public static void init(){
		keys.put("LEFT", Keyboard.KEY_LEFT);
		keys.put("RIGHT", Keyboard.KEY_RIGHT);
		keys.put("UP", Keyboard.KEY_UP);
		keys.put("DOWN", Keyboard.KEY_DOWN);
		keys.put("W", Keyboard.KEY_W);
		keys.put("A", Keyboard.KEY_A);
		keys.put("S", Keyboard.KEY_S);
		keys.put("D", Keyboard.KEY_D);
		keys.put("SPACE", Keyboard.KEY_SPACE);
	}

	public static boolean keyPressed(String key){
		return Keyboard.isKeyDown(keys.get(key));
	}
	
	public void setKeyCommand(String command, String key){
		cmd.put(command, key);
	}
	
	
	public void update(){
		
	}
	
}
