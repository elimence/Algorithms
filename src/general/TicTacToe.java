/**
 *
 */

package general;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

	private int moveCount = 0;
	private PieceSet[][] board;
	private PieceSet winner = null;
	private boolean isGameOver = false;
	private PieceSet turnToPlay = PieceSet.O;

	private enum PieceSet { 
		O(-1), X(1), N(0);

		PieceSet(int val) {
			this.val = val;
		};

		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		private int val;

		@Override
		public String toString() {
			switch(val) {
				case -1: return " O ";
				case  0: return "   ";
				case  1: return " X ";
			}
			return "";
		}
	};

	
	public TicTacToe() {
		board = new PieceSet[3][3];
		for(PieceSet[] row : board) {
			Arrays.fill(row, PieceSet.N);
		}
	}


	public boolean move(PieceSet player, int x, int y) {
		if(x>2 || y>2 || board[x][y] != PieceSet.N) {
			System.out.println("Move not allowed");
		}

		board[x][y] = player;
		moveCount++;
		System.out.println(this);

		if(isWinner(player)) {
			winner = player;
			isGameOver = true;
			return true;
		}
		turnToPlay = (player == PieceSet.O ? PieceSet.X : PieceSet.O);
		return false;
		
	}

	public boolean isDraw() {
		return moveCount == 9;
	}

	public boolean isWinner(PieceSet player) {
		return(
			   (board[0][0].getVal() + board[1][0].getVal() + board[2][0].getVal() == player.getVal() * 3)
			|| (board[0][1].getVal() + board[1][1].getVal() + board[2][1].getVal() == player.getVal() * 3)
			|| (board[0][2].getVal() + board[1][2].getVal() + board[2][2].getVal() == player.getVal() * 3)
			|| (board[0][0].getVal() + board[0][1].getVal() + board[0][2].getVal() == player.getVal() * 3)
			|| (board[1][0].getVal() + board[1][1].getVal() + board[1][2].getVal() == player.getVal() * 3)
			|| (board[2][0].getVal() + board[2][1].getVal() + board[2][2].getVal() == player.getVal() * 3)
			|| (board[0][0].getVal() + board[1][1].getVal() + board[2][2].getVal() == player.getVal() * 3)
			|| (board[0][2].getVal() + board[1][1].getVal() + board[2][0].getVal() == player.getVal() * 3)
		);
	}

	public String getPlayer() {
		return (turnToPlay == PieceSet.O ? "Player 1 (O)" : "Player 2 (X)");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				sb.append(board[i][j]);
				if(j < 2 ) sb.append("|");
			}
			if(i < 2 ) sb.append("\n __________ \n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x,y;

		TicTacToe game = new TicTacToe();
		System.out.println("\t Game Started ..\n" + game.isWinner(game.turnToPlay));
		System.out.println(game);

		while(!game.isGameOver) {
			System.out.print(game.getPlayer() + ": x " );
			x = scan.nextInt();
			System.out.print(game.getPlayer() + ": y " );
			y = scan.nextInt();
			System.out.println("\nYour move: "+ x+ ","+ y);
			boolean result = game.move(game.turnToPlay, x, y);
			if(result) {
				System.out.println(game.getPlayer() + " has won!!!");
				break;
			}
			if(game.isDraw()) {
				System.out.println("Game over!! Draw!!");
				break;
			}
			System.out.println();
		}
		scan.close();
	}
}

