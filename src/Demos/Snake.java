package Demos;

import JavaGame.Display.Font;
import JavaGame.Display.Screen;
import JavaGame.Game;
import JavaGame.Input.Input;
import JavaGame.Sound.Sound;
import JavaGame.Util.Timer;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import java.awt.*;
import java.util.LinkedList;

public class Snake extends Game {


    // Game variables
    private final int GRID_SIZE = 20;
    private Point start;
    private Point food;
    private int gains;
    private int dir; // up 0 right 1 down 2 left 3
    private int nextDir;
    private int[][] grid;
    private Timer timer;
    private Point gridSize;
    private LinkedList<Point> chain;
    private int score;


    // Resources
    private Font font;
    private Sound bgMusic;
    private Sound foodFX;

    public Snake() {
        super(500, 500);
    }

    public static void main(String[] args) {
        Game game = new Snake();
    }

    /**
     * Starts the game
     */
    public void init() {
        Screen.setBGColor(Color.white);

        // Resources Initialization
        font = new Font("res/fonts/SwordArtOnline.ttf", 20f);
        bgMusic = new Sound("res/audio/ChaozFantasy.mp3");
        foodFX = new Sound("res/audio/blink.wav");


        // Game Initialization
        gridSize = new Point((int) Screen.WIDTH / GRID_SIZE, (int) Screen.HEIGHT / GRID_SIZE);
        start = new Point((int) Screen.WIDTH / GRID_SIZE / 2, (int) Screen.HEIGHT / GRID_SIZE / 2);
        chain = new LinkedList<Point>();
        chain.add(new Point(start));
        // Make the grid slightly larger than the screen to store walls outside
        grid = new int[(int) (Screen.WIDTH) / GRID_SIZE + 2][(int) (Screen.HEIGHT) / GRID_SIZE + 2];
        grid[start.x][start.y] = 1;
        // Set walls to 1 to enable the snake to crash into them
        for (int x = 0; x < grid.length; x++) {
            grid[x][0] = 1;
            grid[x][grid[0].length - 1] = 1;
        }
        for (int y = 0; y < grid[0].length; y++) {
            grid[0][y] = 1;
            grid[grid.length - 1][y] = 1;
        }
        gains = 3;
        genFood();


        timer = new Timer(60);
        timer.start();
        bgMusic.loop();
    }

    public void update() {


        if (Input.keyPressed(Keyboard.KEY_UP) && dir != 2)
            dir = 0;
        else if (Input.keyPressed(Keyboard.KEY_RIGHT) && dir != 3)
            dir = 1;
        else if (Input.keyPressed(Keyboard.KEY_DOWN) && dir != 0)
            dir = 2;
        else if (Input.keyPressed(Keyboard.KEY_LEFT) && dir != 1)
            dir = 3;

        // Update only if it is time to move the snake
        if (!timer.tick()) return;


//        dir = nextDir;

        Point next = new Point(chain.getFirst());
        if (dir == 0)
                next.y++;
        else if (dir == 1)
                next.x++;
        else if (dir == 2)
                next.y--;
        else if (dir == 3)
                next.x--;

        // If the snake collides with anything, exit the game
        if (grid[next.x][next.y] > 0) {
            end();
            return;
        }

        // Move the snake forward and make new food if necessary
        grid[next.x][next.y]++;
        chain.addFirst(next);
        grid[chain.getLast().x][chain.getLast().y]--;
        chain.removeLast();

        if (next.equals(food)) {
            for (int i = 0; i < gains; i++) {
                chain.add(new Point(chain.getLast()));
                grid[chain.getLast().x][chain.getLast().y]++;
            }
            score++;
            genFood();
        }
    }

    private void genFood() {

        foodFX.play();
        Point p = new Point(chain.getFirst());
        while (grid[p.x][p.y] > 0) {
            p.x = (int) (Math.random() * (grid.length-2))+1;
            p.y = (int) (Math.random() * (grid[0].length-2))+1;
        }
        food = p;

    }

    public void render() {
        //drawGrid();
        Screen.setColor(Color.black, 100);

        for (int x = 0; x <= Screen.WIDTH; x += GRID_SIZE)
            Screen.drawLine(x, 0, x, Screen.HEIGHT);
        for (int y = 0; y <= Screen.HEIGHT; y += GRID_SIZE)
            Screen.drawLine(0, y, Screen.WIDTH, y);

        //drawSnake();
        Screen.setColor(Color.red);
        for (Point ele : chain) {
            Screen.fillRect((ele.x - 1) * GRID_SIZE + 1, (ele.y - 1) * GRID_SIZE + 1, GRID_SIZE - 3, GRID_SIZE - 3);
        }

        //drawFood();
        Screen.setColor(Color.green);
        Screen.fillCircle(food.x * GRID_SIZE - GRID_SIZE / 2, food.y * GRID_SIZE - GRID_SIZE / 2, GRID_SIZE / 2);

        Screen.setColor(Color.black);
        Screen.fillRect(Screen.WIDTH - 105, 5, 100, 50);
        Screen.setColor(Color.white);
        Screen.fillRect(Screen.WIDTH - 103, 7, 96, 46);
        Screen.setColor(Color.black);
        Screen.drawString(font, score + "", Screen.WIDTH - 80, 10);

    }

}
