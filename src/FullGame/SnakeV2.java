package FullGame;

import FullGame.Model.Grid;
import FullGame.Model.SnakeSegment;
import FullGame.View.ViewComponent;
import JavaGame.*;

import java.awt.*;

public class SnakeV2 extends Game{

    Grid grid;
	public static Dimension GRID_SIZE  = new Dimension(10,10);


    public SnakeV2(int width, int height) {
        super(width, height);
        grid = new Grid(width / GRID_SIZE.width, height / GRID_SIZE.height);



    }

    protected void init() {

    }


    protected void update() {

    }


    protected void render() {

    }
}
