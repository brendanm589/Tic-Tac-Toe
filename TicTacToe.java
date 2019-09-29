package TicTacToe;

import java.util.Scanner;

public class TicTacToe 
{
	
	private static Scanner scanner = new Scanner(System.in);
	private static char board[][] = new char[3][3];
	private static char move = 'X';
	private static int row, col;
	private static int moves = 0;
	private static boolean draw = false;
	
	public static void playGame()
	{
		boolean playing = true;
		while(playing)
		{
			row = scanner.nextInt() - 1;  //the user enters a number for row and column
			col = scanner.nextInt() - 1;
			
			if(board[row][col] == '-')
			{
				board[row][col] = move;  //only allow that spot to be used if it's empty
				moves++;  //increment moves only if it's a valid move
			}
			else
			{
				System.out.print("That spot is taken.");
				printBoard();
				continue;
			}
			
			if(gameOver(row, col))
			{
				playing = false;
				if(draw == false)
				{
					System.out.println("Game Over!");  //if game is over, print the winner and add
					System.out.println("Player " + move + " Wins!"); //one to their score
				}
				
				else
				{
					System.out.println("Game Over!");  //print it's a tie if draw == true
					System.out.println("It's a Tie!");
				}
			}
			
			printBoard();
			
				if(move == 'X')
				{
					move = 'O';
				}                    //make sure turns alternate
				else
				{
					move = 'X';
				}
		}//end while
	}//playGame
	
	public static boolean gameOver(int r, int c)
	{
		//straight line victories
		if(board[0][c] == board[1][c] && board[0][c] == board[2][c])
		{
			return true;
		}
		if(board[r][0] == board[r][1] && board[r][0] == board[r][2])
		{
			return true;
		}
		//diagonal victories
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '-')
		{
			return true;
		}
		if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '-')
		{
			return true;
		}
		if(moves == 9)
		{
			draw = true;  //if the players reach 9 moves and no one wins, it's a draw
			return true;
		}
		
		return false;
		
	}
	
	public static void printBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			
			System.out.println();
			for(int j = 0; j < 3; j++)    //print vertical lines to make the board
			{
				if(j == 0)
				{
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
			}
		}
	}//end printBoard

	public static void main(String[] args) 
	{
		TicTacToe ttt = new TicTacToe();
		for(int i = 0;i < 3; i++)
		{
			for(int j = 0; j < 3; j++)  //initialize every space on the board to -
			{
				board[i][j] = '-';
			}//end j for
		}//end i for
		
		//print instructions before printing board and then playing game
		System.out.println("Please enter a number indicating the row you would like to "
				+ "make your move in (between 1 and 3) and press enter");
		System.out.println("Please enter a number indicating the column you would like to"
				+ "make your move in (between 1 and 3) and press enter");
		printBoard();
		playGame();

	}//end main

}//end class
