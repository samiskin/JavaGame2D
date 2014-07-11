/*
	GraphicsComponent massive tree for each thing, highest class has static variable for what to draw on
	InputComponent has all the bind aspects (bind a method to a control for that object)
	Event Queue for popup messages
	Audio singleton processing a queue of sounds, file to link codenames to mp3files	
	Add logging for debugging purposes (use Decorators to enable it)
	Add classes for basic math stuff like Matrices and Vectors
	Use var_ for instance variables

	Subclass Sandbox
	Component
	Event Queue
	Service Locator
	
	Object Pool
	QuadTree

	Matrices
	Vectors
	Distance
*/




class GameScreen extends Screen
{
	
	public GameScreen()
	{
		game = new Pong();
	}

	public void update()
	{
		game.update();
	}

	public void draw()
	{
		game.draw();
	}


}







class Pong extends Game
{

	private int leftPoints = 0;
	private int rightPoints = 0;
	private ViewComponent view;
	
	public Pong()
	{
		Actor paddleLeft = new Paddle(0,HEIGHT/2);
		Actor paddleRight = new Paddle(WIDTH,HEIGHT/2);
		Ball ball = new Ball(WIDTH/2,HEIGHT/2,5,5);
		view = new PongView(this);
	}

	public void update()
	{

		if (ball.x < ball.radius)
		{
			rightPoints++;
			resetBall();
		} else if (ball.x > WIDTH-ball.radius)
		{
			leftPoints++;
			resetBall();
		} else if (ball.y < ball.radius || ball.y > HEIGHT-ball.radius)
			ball.bounceY();

		if (paddleLeft.collides(ball))
			paddleLeft.bounceBall(ball);
		if (paddleRight.collides(ball))
			paddleRight.bounceBall(ball);


		paddleLeft.update();
		paddleRight.update();
		ball.update();
	}

	private void resetBall()
	{
		ball.setLocation(WIDTH/2,HEIGHT/2);
		ball.setVelocity(5,5);
	}

	public int getLeftScore(){
		return leftPoints;
	}

	public int getRightScore(){
		return rightPoints;
	}



}

class PongView extends ViewComponent
{
	private Pong pongGame_;

	public PongView(Pong pongGame)
	{
		pongGame_ = pongGame;
	}	

	public void draw()
	{

		drawRect(0,0,WIDTH,HEIGHT,Color.BLACK);

		paddleRight.draw();
		paddleLeft.draw();
		ball.draw();

		writeText(pongGame_.getLeftScore(scoreX1,scoreY));
		writeText(pongGame_.getRightScore(scoreX2,scoreY));
	}
}



class Ball
{

	ViewComponent view;

	public Ball(int x, int y, int velX, int velY)
	{
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		width = 10;
		height = 10;
		view = new BallView(this);
	}

	public void update()
	{
		x += velX;
		y += velY;
	}

	public void draw()
	{
		drawOval(x,y,width,height);
	}



	public void bounceX()
	{
		velX *= -1;
	}

	public void bounceY()
	{
		velY *= -1;
	}
}

class BallView extends ViewComponent
{
	Ball ball;

	public BallView(Ball subject)
	{
		ball = subject;
	}

	public void draw()
	{
		drawOval(ball.x,ball.y,ball.radius);
	}
}




class Paddle
{
	InputComponent input;
	ViewComponent view;

	public Paddle(int x, int y)
	{
		this.x = x;
		this.y = y;
		input = new InputComponent(this);
	}

	public void update()
	{
		super.update();

	}

	public void draw()
	{
		drawRect(x,y,width,height);
	}

	public bounceBall(Ball ball)
	{

	}

	public moveUp()
	{
		y++;
	}

	public moveDown()
	{
		y--;
	}

}

class PaddleView extends ViewComponent
{
	Paddle paddle_;

	public PaddleView(Paddle paddle)
	{
		paddle_ = paddle;
	}

	public void draw()
	{
		drawRect(x,y,width,height);
	}

}