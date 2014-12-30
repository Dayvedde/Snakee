import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Game extends JFrame implements Runnable{
	final char LEFT = 'a';
	final char RIGHT = 'd';
	final char UP = 'w';
	final char DOWN = 's';
	
	int x, y;
	char curDirection; 
	
	// Variables for double buffering
	private Image dbImage;
	private Graphics dbg;
	
	public void run(){
		try {
			while (true){
				move ();
				Thread.sleep(30);
			}
		} catch (Exception e){
			
		}
	
	}
	
	// Handle collision in here?
	public void move(){
		if (curDirection == LEFT){
			x -= 10;
		}
		else if (curDirection == RIGHT){
			x += 10;
		}
		else if (curDirection == UP){
			y -= 10;
		}
		else if (curDirection == DOWN){
			y += 10;
		}
		
		// Check for wall Collision, don't use 'else' because of double cases
		if (x <= 0){
			x = 0;
		}
		if (x >= 485){
			x = 485;
		}
		if (y <= 25){
			y = 25;
		}
		if (y >= 485){
			y = 485;
		}
	}
	
	/*
	public void setXDirection(int xdir){
		xDirection = xdir;
	}
	
	public void setYDirection(int ydir){
		yDirection = ydir;
	}
	*/
	
	public void setCurDirection(char c){
		curDirection = c;
	}
	
	// action listener
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode(); // automatically stores key value pressed
			if (keyCode == e.VK_A){
				setCurDirection(LEFT);
			}
			if (keyCode == e.VK_D){
				setCurDirection(RIGHT);
			}
			if (keyCode == e.VK_W){
				setCurDirection(UP);
			}
			if (keyCode == e.VK_S){
				setCurDirection(DOWN);
			}
		}
		public void keyReleased(KeyEvent e){

		}
	}
	
	public Game (){
		addKeyListener(new AL());
		x = 250;
		y = 250;
		setTitle("Snake");	// Name of title
		setSize(500, 500);	//Size of screen
		setResizable(false); //Can user resize?
		setVisible(true); //Can the window be displayed?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Auto terminate the build when JFrame is closed
	}
	
	public void paint (Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	
	public void paintComponent(Graphics g){
		g.fillOval(x,y,15,15);
		repaint();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		// Threads
		Thread t1 = new Thread (game);
		t1.start();
	}
}