
public class Snake {
	private int length;		// how big the snake is
	private char [] snake; // This is the snake itself, char array?? can we use vectors?
	private int xCoord; // x-Coordinate of the head of the snake
	private int yCoord; // y-Coordinate of the head of the snake, we don't need the body coords
	
	// Setters
	public void setLength (int l){ length = l; }
	public void setXCoord (int x){ xCoord = x; }
	public void setYCoord (int y){ yCoord = y; }
	
	// Getters
	public int getLength () { return length; }
	public int getXCoord () { return xCoord; }
	public int getYCoord () { return yCoord; }
}
