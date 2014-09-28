
import JavaGame.*;
import JavaGame.Input.*;
import JavaGame.Output.*;
import JavaGame.Util.*;
import org.newdawn.slick.Color;


/** The
 *
 */
public class Template extends Game{


    protected Template(int width, int height) {
        super(width, height);	// Initialize the game window


		start(); 				// Call this to start the game going through its main loop
    }



	public static void main(String[] args) {
		Game game = new Template(1280,720);
	}

	// All code goes in here
    protected void update() {

    }

}
