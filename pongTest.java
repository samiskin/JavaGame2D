class Pong extends Game
{
	
	public Pong()
	{

		Actor paddleLeft = new Paddle(0,HEIGHT/2);
		Actor paddleRight = new Paddle(WIDTH,HEIGHT/2);
		Ball ball = new Ball(WIDTH/2,HEIGHT/2,5,5);
	}

	public void run()
	{
		if (ball.collides(paddleLeft)
)	}


	public void draw()
	{

	}

}




class GameScreen extends Screen
{
	
	public GameScreen()
	{
		game = new Pong();
	}

	public void run()
	{
		game.run();
	}

	public void draw()
	{
		game.draw();
	}


}



class Ball extends Actor
{
	public Ball(int x, int y, int velX, int velY)
	{
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		width = 10;
		height = 10;
	}

	public void run()
	{
		x += velX;
		y += velY;
	}

	public void draw()
	{
		drawOval(x,y,width,height);
	}

	public boolean collides(Actor actor)
	{
		return rectCollides(this,actor);
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

class Paddle extends Actor
{
	public Paddle(int x, int y)
	{
		this.x = x;
		this.y = y;
		bind(Button.UpArrow, moveUp());
		bind(Button.DownArrow, moveDown());
	}

	public void run()
	{
		super.run();

	}

	public void draw()
	{
		drawRect(x,y,width,height);
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