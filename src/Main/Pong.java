package Main;

import Model.*;

public class Pong extends Game{
	
	Paddle paddleLeft;
	Paddle paddleRight;
	Ball ball;
	
	public Pong(){
		super(640,480);
		paddleLeft = new Paddle(0,Screen.HEIGHT/2,10,100);
		paddleRight = new Paddle(Screen.WIDTH-10,Screen.HEIGHT/2,10,100);
		paddleLeft.setControls("WS");
		ball = new Ball(Screen.WIDTH/2, Screen.HEIGHT/2,10);
		ball.setVel(5, 5);
		start();
	}
	
	
	
	public void update(){
		
		if (paddleLeft.collides(ball) || paddleRight.collides(ball))
			ball.bounceX();
		
		
		paddleLeft.update();
		paddleRight.update();
		ball.update();
	}
	
	
    public static void main(String args[]) {
    	Game game = new Pong();
    }
}
