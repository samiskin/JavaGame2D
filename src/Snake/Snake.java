package Snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;



import JavaGame.Game;
import JavaGame.Screen;

public class Snake extends Game{

	
	private final int GRID_SIZE = 21;
	int dir; // up 0 right 1 down 2 left 3
	
	private LinkedList<Point>chain;
	
	public Snake() {
		super(640, 640);
	}
	
	
	public void init(){
		Screen.setBGColor(Color.WHITE);
		chain = new LinkedList<Point>();
		chain.add(new Point(5,5));
	}
	
	public void update() {
		
	}
	
	public void render() {
		drawGrid();
		drawSnake();
	}
	
	private void drawGrid(){
		Screen.setColor(Color.BLACK, 100);
		for (int x = 0; x <= Screen.WIDTH; x += GRID_SIZE)
			Screen.drawLine(x,0,x,Screen.HEIGHT);
		for (int y = 0; y <= Screen.HEIGHT; y+= GRID_SIZE)
			Screen.drawLine(0, y, Screen.WIDTH,y);
	}
	
	private void drawSnake(){
		for (Point ele : chain){
			Screen.fillRect(ele.x*GRID_SIZE+GRID_SIZE/2, ele.y*GRID_SIZE+GRID_SIZE/2, GRID_SIZE-1, GRID_SIZE-1);
		}
	}
	

	public static void main(String[] args){
		Game game = new Snake();
	}
}
