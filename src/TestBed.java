import JavaGame.Game;
import JavaGame.Sound.Sound;
import org.lwjgl.input.Keyboard;


public class TestBed extends Game {

    Sound testSound;

    public TestBed() {
        super(200, 50);
    }

    public static void main(String[] args) {
        Game game = new TestBed();
    }

    protected void init() {
        super.setFPS(60);
        testSound = new Sound("res/audio/Electric Feel.mp3");
        testSound.loop();
    }

    protected void update() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            System.out.println("W");
            testSound.pause();
        } else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            System.out.println("S");
            testSound.resume();
        } else if (Keyboard.isKeyDown(Keyboard.KEY_A))
            testSound.setVolume(0.1);
        else if (Keyboard.isKeyDown(Keyboard.KEY_D))
            testSound.setVolume(1);


    }

    protected void render() {


    }

}
