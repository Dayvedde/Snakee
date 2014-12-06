// TextDisplay used to show the board, link to a board class?
public class TextDisplay {
	
	String [] grid;
	
	public TextDisplay (){
		
		grid = new String [5];
		grid [0] = "|----------|";
		grid [1] = "|..........|";
		grid [2] = "|..........|";
		grid [3] = "|..........|";
		grid [4] = "|----------|";
	}
	
	public void printDisplay (){
		for (int i = 0; i < 5; i++){
			System.out.println(grid[i]);
		}
	}
	
}
