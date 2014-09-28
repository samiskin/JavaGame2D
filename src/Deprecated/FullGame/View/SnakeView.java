package FullGame.View;

import FullGame.Model.SnakeSegment;
import JavaGame.Output.Screen;
import org.newdawn.slick.Color;

import java.awt.Point;
import java.util.LinkedList;


/**
 * Created by Dragon on 8/3/2014.
 */
public class SnakeView extends ViewComponent{
	public SnakeSegment snake;

	public SnakeView(SnakeSegment head){
		snake = head;
	}


	public void render() {
		LinkedList<Point> points = snake.getPositions();
		for (Point p : points){
			fillCell(p.x, p.y, Color.red);
		}
	}
}
