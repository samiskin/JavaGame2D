package Main.Pong;

import JavaGame.InputComponent;

public class PaddleController extends InputComponent{
	private Paddle paddle;
	private String upKey;
	private String downKey;
	
	public PaddleController(Paddle target){
		paddle = target;
		setKeyCommand("UP","UP");
		setKeyCommand("DOWN","DOWN");
	}
	
	public void update(){
		if (keyPressed(cmd.get("UP")))
			paddle.moveUp();
		if (keyPressed(cmd.get("DOWN")))
			paddle.moveDown();
	}
}
