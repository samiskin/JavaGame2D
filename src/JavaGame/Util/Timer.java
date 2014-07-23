package JavaGame.Util;

import JavaGame.Display.Screen;

public class Timer {


    long start;
    long previous;
    long period;

    public Timer(long period) {
        this.period = period;
    }

    public void start() {
        start = Screen.getTime();
        previous = start;
    }

    public void stop() {
        start = 0;
    }

    public boolean tick() {
        long current = Screen.getTime();
        if (current - previous > period) {
            previous = current;
            return true;
        }
        return false;
    }

    public long timeLeft() {
        return period - (Screen.getTime() - previous);
    }

    public long timeSinceStart() {
        return Screen.getTime() - start;
    }

    public long accelerate(long miliseconds) {
        period += miliseconds;
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }


}
