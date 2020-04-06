package drewJoseph.apcsamod.chess;

import java.awt.Point;

public class Board {
	public static Point selection1;
	public static boolean turnWhite = true;
	public static ChessPiece[][] board = new ChessPiece[8][8];
	
	public Board() {

		for (int i = 0; i < board.length; i++)
			board[6][i] = new Pawn(6, i, 0);
		for (int i = 0; i < board.length; i++)
			board[1][i] = new Pawn(1, i, 1);
		board[0][4] = new King(0, 4, 1);
		board[7][4] = new King(7, 4, 0);
		board[0][3] = new Queen(0, 3, 1);
		board[7][3] = new Queen(7, 3, 0);
		board[0][2] = new Bishop(0, 2, 1);
		board[7][2] = new Bishop(7, 2, 0);
		board[0][5] = new Bishop(0, 5, 1);
		board[7][5] = new Bishop(7, 5, 0);
		board[0][1] = new Knight(0, 1, 1);
		board[7][6] = new Knight(7, 6, 0);
		board[0][6] = new Knight(0, 6, 1);
		board[7][1] = new Knight(7, 1, 0);
		board[7][7] = new Rook(7, 7, 0);
		board[7][0] = new Rook(7, 0, 0);
		board[0][7] = new Rook(0, 7, 1);
		board[0][0] = new Rook(0, 0, 1);
	}
	public static void showMoves() {
		
	}
	public void render() {
		for (ChessPiece[] row : board)
			for(ChessPiece piece : row)
				piece.render();
	}
}
