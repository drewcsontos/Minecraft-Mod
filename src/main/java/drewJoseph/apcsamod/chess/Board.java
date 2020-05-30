package drewJoseph.apcsamod.chess;

import java.awt.Point;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class Board {
	public Point selection1;
	public boolean turnWhite = true;
	public ChessPiece[][] board = new ChessPiece[8][8];
	public Board() {

		for (int i = 0; i < board.length; i++)
			board[6][i] = new Pawn(6, i, 0, this);
		for (int i = 0; i < board.length; i++)
			board[1][i] = new Pawn(1, i, 1,this);
		board[0][4] = new King(0, 4, 1,this);
		board[7][4] = new King(7, 4, 0,this);
		board[0][3] = new Queen(0, 3, 1,this);
		board[7][3] = new Queen(7, 3, 0,this);
		board[0][2] = new Bishop(0, 2, 1,this);
		board[7][2] = new Bishop(7, 2, 0,this);
		board[0][5] = new Bishop(0, 5, 1,this);
		board[7][5] = new Bishop(7, 5, 0,this);
		board[0][1] = new Knight(0, 1, 1,this);
		board[7][6] = new Knight(7, 6, 0,this);
		board[0][6] = new Knight(0, 6, 1,this);
		board[7][1] = new Knight(7, 1, 0,this);
		board[7][7] = new Rook(7, 7, 0,this);
		board[7][0] = new Rook(7, 0, 0,this);
		board[0][7] = new Rook(0, 7, 1,this);
		board[0][0] = new Rook(0, 0, 1,this);
	}
	public static void showMoves() {
		
	}
	public void render() {
		for (ChessPiece[] row : board)
			for(ChessPiece piece : row)
				piece.render();
	}
	public void select(int row, int col) {
		if(selection1==null&&board[row][col]!=null) {
			selection1 = new Point(row,col);
			System.out.println("Made new point");
		}
		else if(new Point(row,col).equals(selection1)) {
			selection1 = null;
			System.out.println("Nulled selection1");
		}
		else if(selection1!=null){
			board[selection1.x][selection1.y].move(row,col);
			selection1 = null;
			System.out.println("moved piece");
		}
	}
	public String toString() {
		String s = "\n";
		for(int row=0;row<8;row++) {
			for(int col=0;col<8;col++)
				if(board[row][col]!=null)
					s+=board[row][col].getType();
				else
					s+=" ";
			s += "\n";
		}
		return s;
	}
}
