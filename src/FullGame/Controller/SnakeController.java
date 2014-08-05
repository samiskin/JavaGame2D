package FullGame.Controller;

import FullGame.Model.SnakeSegment;

import static JavaGame.Input.Input.*;

public class SnakeController  extends ControlComponent{
    private SnakeSegment snake;


    public SnakeController(SnakeSegment snakeHead){
        this.snake = snakeHead;
    }


    public void update() {
        if (keyPressed(KEY_W))
            snake.moveUp();
	    else if (keyPressed(KEY_A))
			snake.moveLeft();
		else if (keyPressed(KEY_S))
			snake.moveDown();
		else if (keyPressed(KEY_D))
			snake.moveRight();
    }

}
