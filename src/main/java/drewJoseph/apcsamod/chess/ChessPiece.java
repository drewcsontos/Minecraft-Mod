package drewJoseph.apcsamod.chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public abstract class ChessPiece {
	protected int row, col, type, color;
	static final int PAWN = 0, KNIGHT = 1, BISHOP = 2, ROOK = 3, QUEEN = 4, KING = 5;
	static final int WHITE = 0, BLACK = 1;
	public ChessPiece(int row, int col, int type,int color) {
		this.row=row;
		this.col=col;
		this.type = type;
		this.color = color;
	}

	public abstract boolean canTakePiece(ChessPiece[][] board, int endX, int endY);
	public abstract Point[] canMove();
	public abstract void render();
	public void move(int row, int col) {
        Board.board[this.row][this.col]=null;	
        Board.board[row][col]=this;
		this.row = row;
		this.col = col;
	}
	public String toString() {
		return ""+row+col+type+color;
	}
}