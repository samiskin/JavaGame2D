package FullGame.View;

import FullGame.Model.Grid;
import JavaGame.Output.Screen;
import org.newdawn.slick.Color;

import java.awt.*;

/**
 * Created by Dragon on 8/3/2014.
 */
public class GridView extends ViewComponent{


	Grid grid;



	public GridView (Grid grid){
		this.grid = grid;
	}


	public void render() {
		Screen.setColor(Color.white);
		Screen.fillRect(0,0,Screen.width,Screen.height);
		Screen.setColor(Color.black, 100);
		for (int x = 0; x <= Screen.width; x += GRID_SIZE.width)
			Screen.drawLine(x, 0, x, Screen.height);
		for (int y = 0; y <= Screen.height; y += GRID_SIZE.height)
			Screen.drawLine(0, y, Screen.width, y);

	}
}
