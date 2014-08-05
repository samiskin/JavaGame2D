package FullGame.Model;

import FullGame.View.GridView;
import FullGame.View.ViewComponent;

import java.awt.Point;
import java.util.LinkedList;

/**
 * Created by Shiranka on 7/31/2014.
 */
public class Grid {

    int width,height;
    Tile[][]grid;
	ViewComponent view;
	SnakeSegment snake;
	LinkedList<SnakeSegment> heads;


    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        grid = new Tile[width][height];
		view = new GridView(this);
		heads = new LinkedList<>();
		snake = new SnakeSegment(new Point(width /2, height /2));


    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }












}
