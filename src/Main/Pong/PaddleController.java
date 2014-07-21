package Main.Pong;

import org.lwjgl.input.Keyboard;

import JavaGame.Input;

public class PaddleController extends Input{
	private Paddle paddle;
	private String upKey;
	private String downKey;
	
	public PaddleController(Paddle target){
		paddle = target;
		setKeyCommand("UP",Keyboard.KEY_UP);
		setKeyCommand("DOWN",Keyboard.KEY_DOWN);
	}
	
	public void update(){
		if (keyPressed(cmd.get("UP")) && !keyPressed(cmd.get("DOWN")))
			paddle.moveUp();
		else if (keyPressed(cmd.get("DOWN")) && !keyPressed(cmd.get("UP")))
			paddle.moveDown();
		else
			paddle.noInput();
	}
}
