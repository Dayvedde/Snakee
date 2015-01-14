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
	final int delay = 100;
	
	final int START_POS_X = 250;
	final int START_POS_Y = 250;
	
	Snake snake = new Snake(0,START_POS_X,START_POS_Y);

	
	
	int x, y;
	char curDirection; 
	
	// Variables for double buffering
	private Image dbImage;
	private Graphics dbg;
	
	public void run(){
		snake.addBodyPart();
		snake.addBodyPart();
		try {
			while (true){
				move ();
				Thread.sleep(100);
			}
		} catch (Exception e){
			
		}
	}
	
	// Handle collision in here?
	public void move(){
		int curXPos = snake.getXCoord();
		int curYPos = snake.getYCoord();
		
		if (curDirection == LEFT){
			curXPos -= 15;
			snake.setXCoord(curXPos);
		}
		else if (curDirection == RIGHT){
			curXPos += 15;
			snake.setXCoord(curXPos);
		}
		else if (curDirection == UP){
			curYPos -= 15;
			snake.setYCoord(curYPos);
		}
		else if (curDirection == DOWN){
			curYPos += 15;
			snake.setYCoord(curYPos);
		}
		
		// Check for wall Collision, don't use 'else' because of double cases
		if (curXPos <= 2){
			snake.setXCoord(2);
		}
		if (curXPos >= 483){
			snake.setXCoord(483);
		}
		if (curYPos <= 25){
			snake.setYCoord(25);
		}
		if (curYPos >= 482){
			snake.setYCoord(482);
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
		snake.drawSnake(g);
		repaint();
	}
	
	// spawn a new apple on the map
	public void spawnApple(){
	
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		// Threads
		Thread t1 = new Thread (game);
		t1.start();
	}
}