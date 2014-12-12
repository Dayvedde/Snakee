// TextDisplay used to show the board, link to a board class?
public class TextDisplay implements Runnable{
	private int rows = 12;
	private int cols = 16;
	private int xPos = 7;
	private int yPos = 7;
	
	private char[] [] grid = {
			{'|', '-', '-','-','-','-','-','-','-','-','-','-','-','-','-','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
			{'|', '-', '-','-','-','-','-','-','-','-','-','-','-','-','-','|'}
			};
	
	public TextDisplay (){
		grid [xPos][yPos] = '@';
	}
	
	public void printDisplay (){
		for (int i = 0; i < rows; i++){
			for (int k = 0; k < cols; k++){
				System.out.print(grid[i][k]);
			}
			System.out.println("");
		}
	}
	
	public void setCell(char symbol, int r, int c){
		if (r > 0 && c > 0 && r < rows && c < cols){
			grid[r][c] = symbol;
		} else {
			System.out.println ("Invalid in setCell");
		}
	}
	
	public void moveSnake(char direction){
		switch (direction){
			case 'w': 
				grid[yPos][xPos] = ' ';
				yPos--;
				grid[yPos][xPos] = '@';
				break;
			case 's': 
				grid[yPos][xPos] = ' ';
				yPos++;
				grid[yPos][xPos] = '@';
				break;
			default:
				System.out.println ("Invalid.");
				break;
		}
	}
	
	public void run(){
		try {
			while (true){
				moveSnake('s');
				this.printDisplay();
				Thread.sleep(1000);
			}
		} catch (Exception e){}
	}
}







