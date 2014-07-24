package JavaGame.Input;

import java.util.LinkedList;

/**
 * Created by Shiranka Miskin on 2014-07-24.
 */
public class MouseBroadcaster {

    private static LinkedList<MouseObserver> observers = new LinkedList<MouseObserver>();

    protected static void update(){
        for (MouseObserver listener : observers){
            listener.notify();
        }
    }

    protected static void addObserver(MouseObserver observer){
        observers.add(observer);
    }

    protected static void removeObserver(MouseObserver observer){
        observers.remove(observer);
    }
}
