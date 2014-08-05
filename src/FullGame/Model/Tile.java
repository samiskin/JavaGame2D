package FullGame.Model;

/**
 * Created by Dragon on 8/3/2014.
 */
public class Tile {

    double value;


    public boolean collides(){
        return value > 0;
    }

}
