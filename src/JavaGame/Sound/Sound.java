package JavaGame.Sound;


import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.net.MalformedURLException;
import java.net.URL;


public class Sound {


    public BasicPlayer player;
    URL fileURL;
    private boolean looping;

    public Sound(String path) {
        String fullPath = System.getProperty("user.dir") + "/" + path;
        player = new BasicPlayer();

        try {
            fileURL = new URL("file:///" + fullPath);
            player.open(fileURL);
        } catch (BasicPlayerException | MalformedURLException e) {
            e.printStackTrace();
        }

        looping = false;
    }

    public void play() {
        try {
            if (player.getStatus() == 2)
                player.open(fileURL);
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
        looping = true;
        play();
    }

    public void setVolume(double vol) {
        try {
            player.setGain(vol);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void seek(double pos){
        try {
            player.seek(50);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void setPan(double pan){
        try {
            player.setPan(pan);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        if (looping = true){
            if (player.getStatus() == 2)
                play();
        }
    }

}
