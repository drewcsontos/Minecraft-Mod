package drewJoseph.apcsamod.chess;

import java.awt.Graphics;
import java.awt.Point;

public class Queen extends ChessPiece {
	public Queen(int row, int col, int color) {
		super(row, col, ChessPiece.ROOK, color);
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
