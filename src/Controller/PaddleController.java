package Controller;

import Model.Paddle;

public class PaddleController extends InputComponent{
	private Paddle paddle;
	
	public PaddleController(Paddle target){
		paddle = target;
	}
	
	
	public void update(){
		if (keyPressed("UP"))
			paddle.moveUp();
		if (keyPressed("DOWN"))
			paddle.moveDown();
	}
}
