package Controller;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;

public abstract class InputComponent{
	
	protected static HashMap<String,Integer> keys = new HashMap<String,Integer>();
	
	public static void init(){
		keys.put("LEFT", Keyboard.KEY_LEFT);
		keys.put("RIGHT", Keyboard.KEY_RIGHT);
		keys.put("UP", Keyboard.KEY_UP);
		keys.put("DOWN", Keyboard.KEY_DOWN);
		keys.put("W", Keyboard.KEY_W);
		keys.put("A", Keyboard.KEY_A);
		keys.put("S", Keyboard.KEY_S);
		keys.put("D", Keyboard.KEY_D);
	}

	protected boolean keyPressed(String key){
		return Keyboard.isKeyDown(keys.get(key));
	}
	
	
	public abstract void update();
	
}
