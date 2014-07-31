package FullGame;

/**
 * Created by Shiranka on 7/31/2014.
 */
public class SnakeSegment {

    private SnakeSegment child;
    private SnakeSegment parent;
    private Point pos;
    private Point vel;
    private Point dir;


    public SnakeSegment(Point spawnLocation){
        pos = spawnLocation;
    }

    public void update(){
        if (parent != null){
            dir.x = parent.pos.x - pos.x;
            dir.y = parent.pos.y - pos.y;
        }
        pos.x += dir.x;
        pos.y += dir.y;
        vel = dir;
    }3

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
