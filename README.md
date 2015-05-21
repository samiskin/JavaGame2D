JavaGame2D
==========


This library is meant to provide a user-friendly way of doing the basic tasks needed to make a simple 2D game.
It gives beginner programmers the chance to make a game without having to worry about the more tiresome aspects
such as figuring out display and input as well as providing some useful tools such as Box2D based physics.

If you'd like to use this and have any issues, please contact me at shiranka.miskin@gmail.com.  There are many things I could add to improve on this but time has become a bit of an issue.  
At the moment I use it mainly to test ideas really easily since all the overhead I/O is easy to do and I'm not worried about efficiency


##Getting Started

TODO:  Make this process easier, its kind of annoying at the moment.  Probably need to remove some stuff, maybe convert entirely to LWJGL 3

Add the JavaGame folder to your workspace and import the necessary packages (Ex: Input, Output, Util)
Add the JARs and Natives to your project
Your main class that contains the game loop should look like:

  ```java
public class MainGame extends Game {
  public MainGame ()
  {
    super(640,400); // width and height of the window
    // Run your startup code
    start();
  }
  
  public void update(){  }
}
  ```


##Usage


###Input

Keyboard input is done using `Input.keyPressed` followed by a keyboard code (full list can be found in the Input file)
```java
if (Input.keyPressed(Input.KEY_UP))
  y++;
```
Mouse input is done in a similar fashion with the MouseEvent class
```java
MouseEvent.getX();          // Returns the X coordinate of the Mouse 
MouseEvent.getY();          // Returns the Y coordinate of the Mouse
MouseEvent.getCtrlKey();    // Checks if the left or right Control key is pressed
MouseEvent.getShiftKey();   // Checks if the left or right Control key is pressed
MouseEvent.getAltKey();     // Checks if the left or right Control key is pressed
MouseEvent.getButton();     // Returns which mouse button has been pressed
```

File Input is done using the FileReader class
```java
FileReader in = new FileReader("res/input.txt");
String line = in.readLine();
ArrayList<String> lines = in.getLines();
String full = in.getFullText();
```


###Output

Shapes can be drawn to the screen using the Screen class
```java
Screen.setColor(Color.RED);   // Color class from org.newdawn.slick.Color;
Screen.drawRect(0,0,100,100);
Screen.fillCircle(0,0,10);
```

Text can be done by loading a Font and drawing it to Screen
```java
Font font = new Font("res/font.ttf", 12);
Screen.drawString(font, "Hello World", 10, 10);
```

Images are drawn similarily with the Image class
```java
Image img = new Image("res/image.png"); // pngs are default
Image jpeg = new Image("res/image.jpg", "jpg");
img.render(0, 0, 100, 100);
```

Sound is done with the Sound class and supports basic play / loop functionality
```java
Sound bgMusic = new Sound("res/song.mp3");
bgMusic.loop(); // Loop continuously
Sound effect = new Sound("res/effect.wav");
effect.play();  // Play once
bgMusic.setVolume(0.1);
bgMusic.pause();
bgMusic.resume();
```

File output uses the FileWriter class
```java
FileWriter out = new FileWriter("output.txt");
out.write("Hello");
out.write(" World");
out.writeLine("!"); // Includes a new line at the end
out.close();
out.getReader();  // returns a FileReader object of the file
```

