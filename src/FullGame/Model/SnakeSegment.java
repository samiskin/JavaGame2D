package FullGame.Model;

import FullGame.Controller.ControlComponent;
import FullGame.Controller.SnakeController;
import FullGame.View.SnakeView;
import FullGame.View.ViewComponent;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Shiranka on 7/31/2014.
 */
public class SnakeSegment {

    private SnakeSegment child;
    private SnakeSegment parent;
    private Point pos;
    private Point vel;
    private Point dir;

	private ControlComponent control;
	private ViewComponent view;


    public SnakeSegment(Point spawnLocation){
        pos = spawnLocation;
		control = new SnakeController(this);
		view = new SnakeView(this);

    }

    public void update(){
        if (parent != null){
            dir.x = parent.pos.x - pos.x;
            dir.y = parent.pos.y - pos.y;
        }
        pos.x += dir.x;
        pos.y += dir.y;
        vel = dir;
    }

    public void moveUp(){
        if (vel.y != -1)
            dir.y = -1;
    }

    public void moveDown(){
        if (vel.y != 1)
            dir.y = 1;
    }

    public void moveLeft(){
        if (vel.x != 1)
            dir.x = -1;
    }

    public void moveRight(){
        if (vel.x != -1)
            dir.x = 1;
    }

    public boolean collidesBody(Point other){
        if (other.equals(pos))
            return true;
        if (child != null)
            return child.collidesBody(other);
        return false;
    }

	public LinkedList<Point> getPositions(){
		LinkedList<Point> points = new LinkedList<>();
		addPositions(points);
		return points;
	}

	private void addPositions(Collection<Point> list){
		list.add(this.pos);
		if (child != null)
			child.addPositions(list);
	}

    public void setParent(SnakeSegment newParent){
        parent = newParent;
    }

    public void setChild(SnakeSegment newChild){
        child = newChild;
    }

    public SnakeSegment getHead(){
        if (parent != null)
            return parent.getHead();
        return this;
    }

    public SnakeSegment getTail(){
        if (child != null)
            return child.getTail();
        return this;
    }






}
