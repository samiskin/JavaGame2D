package Main;

import Model.*;

public class Pong extends Game{
	
	Paddle paddleLeft;
	Paddle paddleRight;
	Ball ball;
	
	public Pong(){
		super();
		paddleLeft = new Paddle(0,Screen.HEIGHT/2,10,100);
		paddleRight = new Paddle(Screen.WIDTH-10,Screen.HEIGHT/2,10,100);
		ball = new Ball(Screen.WIDTH/2, Screen.HEIGHT/2,10);
		ball.setVel(5, 5);
		start();
	}
	
	public void init(){
		
	}
	
	public void update(){
		paddleLeft.update();
		paddleRight.update();
		ball.update();
	}
	
	
    public static void main(String args[]) {
    	Game game = new Pong();
    }
}
