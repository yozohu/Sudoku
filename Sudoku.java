import java.util.*;

public class Sudoku{
	int[][] solution;
	int[][] board;
	Random generator = new Random();

	public Sudoku(){
		solution = new int[9][9];
		board = new int[9][9];
	}

	public void createSolution(){
	
		int[][] temp = new int[9][9];
		int spot;
		int row = 0;

		while(row<9){


			do{
				for(int i = 0; i<9 ;i++){
					temp[row][i] = 0;
				}

				for(int i = 0; i<9; i++){ //randomizes first row
					do{
						spot = generator.nextInt(9);
					}while(temp[row][spot] != 0);
					temp[row][spot] = i+1;
				}
				

			}while(!valid(temp));
			
			row++;

		}
		printArray(temp);

	}

	public boolean valid(int[][] a){
		for(int i = 0; i< 9; i++){
			if(!(validCol(a, i) && validSquare(a, i)) ){
				return false;
			}
		}
		return true;
	}


	public boolean validCol(int[][] a, int n){
		int[] count = new int[9];
		for(int i = 0; i< 9; i++){
			if(a[i][n] != 0){
				count[a[i][n]-1]++;
			}
		}

		for(int i = 0; i<9; i++){
			if(count[i] > 1){
				return false;
			}
		}

		return true;
	}

	public boolean validSquare(int[][] a, int n){

		int r  = n/3;
		r*=3;

		int c = n%3;
		c*=3;

		int[] count = new int[9];
		for(int i = r; i< r+3; i++){

			for(int j = c; j< c+3; j++){
				if(a[i][j] != 0){
					count[a[i][j]-1]++;
				}
			}
		
		}

		for(int i = 0; i<9; i++){
			if(count[i] > 1){
				return false;
			}
		}

		return true;
	}



	public static void printArray(int[][] a){
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				System.out.print("["+a[i][j]+"]");
			}
			System.out.println();
		}
	}
	public void display(){
		printArray(board);
	}

	public static void main(String[] args){
		Sudoku s = new Sudoku();
		s.createSolution();
	}
}