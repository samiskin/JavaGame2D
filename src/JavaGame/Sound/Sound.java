package JavaGame.Sound;


import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.net.MalformedURLException;
import java.net.URL;


public class Sound {


    BasicPlayer player;

    public Sound(String path) {
        String fullPath = System.getProperty("user.dir") + "/" + path;
        player = new BasicPlayer();
        try {
            player.open(new URL("file:///" + fullPath));
        } catch (BasicPlayerException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            player.play();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        try {
            player.pause();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        try {
            player.resume();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void loop() {
        play();
    }

    public void setVolume(double vol) {
        try {
            player.setGain(vol);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }


}
