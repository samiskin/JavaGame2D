package Snake;
import java.awt.Point;
import java.util.LinkedList;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import JavaGame.Game;
import JavaGame.Input;
import JavaGame.Display.Screen;
import JavaGame.Util.Timer;

public class Snake extends Game{
	
	private final int GRID_SIZE = 20;
	private Point start;
	private Point food;
	private int gains;
	private int dir; // up 0 right 1 down 2 left 3
	private int[][] grid;
	private Timer timer;
	private Point gridSize;
	
	private LinkedList<Point>chain;
	
	public Snake() {
		super(500, 500);
	}	
	
	
	/** Starts the game
	 */
	public void init(){
		Screen.setBGColor(Color.white);
		
		gridSize = new Point((int)Screen.WIDTH/GRID_SIZE,(int)Screen.HEIGHT/GRID_SIZE);
		start = new Point((int)Screen.WIDTH/GRID_SIZE/2,(int)Screen.HEIGHT/GRID_SIZE/2);
		
		chain = new LinkedList<Point>();
		chain.add(new Point(start));
		grid = new int[(int)(Screen.WIDTH)/GRID_SIZE+2][(int)(Screen.HEIGHT)/GRID_SIZE+2];
		grid[start.x][start.y] = 1;
		
		// Set walls to 1 to enable the snake to 
		for (int x = 0; x < grid.length;x++){
			grid[x][0] = 1;
			grid[x][grid[0].length-1] = 1;
		}
		for (int y = 0; y < grid[0].length; y++){
			grid[0][y] = 1;
			grid[grid.length-1][y] = 1;
		}
		gains = 3;
		genFood();
		timer = new Timer(60);
		timer.start();
	}
	
	public void update() {
		
		
		if (Input.keyPressed(Keyboard.KEY_W) && dir != 2)
			dir = 0;
		else if (Input.keyPressed(Keyboard.KEY_D) && dir != 3)
			dir = 1;
		else if (Input.keyPressed(Keyboard.KEY_S) && dir != 0)
			dir = 2;
		else if (Input.keyPressed(Keyboard.KEY_A) && dir != 1)
			dir = 3;
		
		// Update only if it is time to move the snake
		if (!timer.tick()) return;
				
		Point next = new Point(chain.getFirst());
		switch (dir) {
		case 0:	next.y--;
		break;
		case 1: next.x++;
		break;
		case 2: next.y++;
		break;
		case 3: next.x--;
		break;
		}
		
		// If the snake collides with anything, exit the game
		if (grid[next.x][next.y] > 0){
			end();
			return;
		}
		
		// Move the snake forward and make new food if necessary
		grid[next.x][next.y]++;
		chain.addFirst(next);
		grid[chain.getLast().x][chain.getLast().y]--;
		chain.removeLast();
		
		if (next.equals(food)){
			for (int i = 0; i < gains; i++){
				chain.add(new Point(chain.getLast()));
				grid[chain.getLast().x][chain.getLast().y]++;
			}
			
			genFood();
		}
	}
	
	private void genFood(){
		
		Point p = new Point(chain.getFirst());
		while (grid[p.x][p.y] > 0){
			p.x = (int)(Math.random()*grid.length);
			p.y = (int)(Math.random()*grid[0].length);
		}
		food = p;
		
	}
		
	public void render() {
		
		//drawGrid();
		Screen.setColor(Color.black, 100);
		for (int x = 0; x <= Screen.WIDTH; x += GRID_SIZE)
			Screen.drawLine(x,0,x,Screen.HEIGHT);
		for (int y = 0; y <= Screen.HEIGHT; y+= GRID_SIZE)
			Screen.drawLine(0, y, Screen.WIDTH,y);
		
		//drawSnake();
		Screen.setColor(Color.red);
		for (Point ele : chain){
			Screen.fillRect((ele.x-1)*GRID_SIZE+1, (ele.y-1)*GRID_SIZE+1, GRID_SIZE-3, GRID_SIZE-3);
		}		
		
		//drawFood();
		Screen.setColor(Color.green);
		Screen.fillOval(food.x*GRID_SIZE-GRID_SIZE/2, food.y*GRID_SIZE-GRID_SIZE/2, GRID_SIZE/2);
		
	}
	

	public static void main(String[] args){
		Game game = new Snake();
	}
}
