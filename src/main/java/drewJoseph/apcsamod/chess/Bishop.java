package drewJoseph.apcsamod.chess;

import java.awt.Graphics;
import java.awt.Point;

public class Bishop extends ChessPiece {
	public Bishop(int row, int col, int color, Board board) {
		super(row, col, ChessPiece.BISHOP, color, board);
	}

	@Override
	public boolean canTakePiece(ChessPiece[][] board, int endX, int endY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point[] canMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}