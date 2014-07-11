package View;

import java.awt.Color;

import Model.Paddle;

public class PaddleView extends ViewComponent{
	private Paddle paddle;
	
	public PaddleView(Paddle target){
		paddle = target;
	}

	public void update(){
		screen.fillRect((int)paddle.getX(),(int)paddle.getY(), paddle.getWidth(), paddle.getHeight(), Color.white);
	}
	
	
}
