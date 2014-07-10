package Main;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Window extends JFrame{

	
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	Engine engine_;
	private DrawingPanel panel;
	boolean running;
	
	public Window (int width, int height, Engine engine)
	{
		super("MainScreen");
		this.setSize(width,height);
		WIDTH = width;
		HEIGHT = height;

		engine_ = engine;

		setVisible(true);
		
		panel = new DrawingPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		running = true;
		
	}
	
	
	public void start()
	{
		while(running){
			engine_.update();
			panel.repaint();
		}
	}
	
	public void stop()
	{
		running = false;
	}
	
	
	private class DrawingPanel extends JPanel
	{

		MouseHandler mouse;
		Timer timer;

		public DrawingPanel()
		{
			this.setFocusable(true);

			mouse = new MouseHandler();
			this.addMouseListener(mouse);
			this.addMouseMotionListener(mouse);
			this.addKeyListener(new KeyHandler());
			setBackground(Color.black);
			setResizable(false);
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			engine_.draw(g);
		}


	}
	

	private class MouseHandler extends MouseAdapter
	{
	
		public void mousePressed(MouseEvent event)
		{
			engine_.mousePressed(event);
		}

		public void mouseReleased(MouseEvent event)
		{
			engine_.mouseReleased(event);
		}

		public void mouseMoved(MouseEvent event)
		{
			engine_.mouseMoved(event);
		}
		
		public void mouseDragged(MouseEvent event)
		{
			engine_.mouseDragged(event);		
		}
	}

	
	private class KeyHandler extends KeyAdapter
	{
		
		public void keyPressed(KeyEvent event)
		{
			engine_.keyPressed(event);
		}
		
	}

	
	
	
	
}
