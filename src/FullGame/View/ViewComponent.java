package FullGame.View;

import FullGame.SnakeV2;
import JavaGame.Output.Screen;
import org.newdawn.slick.Color;

import java.awt.*;

/**
 * Created by Dragon on 8/3/2014.
 */
public abstract class ViewComponent {

	protected static Point gridOffset = new Point(0,0);
	protected Dimension GRID_SIZE = SnakeV2.GRID_SIZE;


    public abstract void render();

	protected void fillCell(int x, int y, Color color){
		Screen.setColor(color);
		Screen.fillRect(x* GRID_SIZE.width+gridOffset.x,y*GRID_SIZE.height+gridOffset.y,GRID_SIZE.width,GRID_SIZE.height);
	}

}
