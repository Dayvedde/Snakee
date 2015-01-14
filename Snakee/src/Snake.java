import java.awt.Graphics;

public class Snake {
	private int length;		// how big the snake is
	private int bodyPart; //A number indicating which part of the snake this body part is, 0 = head
	private int xCoord; // x-Coordinate of the head of the snake
	private int yCoord; // y-Coordinate of the head of the snake, we don't need the body coords
	private Snake nextBodyPart;
	
	// Setters
	public void setLength (int l){ length = l; }
	public void setXCoord (int x){
		if (nextBodyPart != null){
			nextBodyPart.setXCoord(xCoord);
			nextBodyPart.setYCoord(yCoord);
		}
		xCoord = x; 
	}
	public void setYCoord (int y){ 
		if (nextBodyPart != null){
			nextBodyPart.setYCoord(yCoord);
			nextBodyPart.setXCoord(xCoord);
		}
		yCoord = y; 
	}
	
	public void changeCoords(int x, int y){
		if (x == xCoord && y == yCoord){
			return;
		}
		if (nextBodyPart != null){
			nextBodyPart.changeCoords (xCoord, yCoord);
		}
		xCoord = x;
		yCoord = y;
	}
	public void setBodyPart (int bp){ bodyPart = bp; }
	
	// Getters
	public int getLength () { return length; }
	public int getXCoord () { return xCoord; }
	public int getYCoord () { return yCoord; }
	public int getBodyPart (int bp){ return bodyPart; }
	
	public Snake (int bodyPos, int x, int y){
		bodyPart = bodyPos;
		xCoord = x;
		yCoord = y;
		nextBodyPart = null;
	}
	
	public void addBodyPart(){
		if (nextBodyPart == null){
			nextBodyPart = new Snake (bodyPart++, xCoord - 15, yCoord);
		}
		else {
			nextBodyPart.addBodyPart();
		}
	}
	
	public void drawSnake(Graphics g){
		g.fillOval(xCoord,yCoord,15,15);
		if (nextBodyPart != null){			
			nextBodyPart.drawSnake(g);
			
		}
	}
}
