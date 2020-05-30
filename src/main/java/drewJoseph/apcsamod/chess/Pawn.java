package drewJoseph.apcsamod.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Pawn extends ChessPiece {
	public Pawn(int row, int col, int color, Board board) {
		super(row, col, ChessPiece.PAWN, color, board);
	}

	@Override
	public Point[] canMove() {
		ArrayList<Point> points = new ArrayList<Point>();
		Point[] temp;
		if (this.color == 0) {
			if (board.board[this.row - 1][this.col] == null)
				points.add(new Point(this.row - 1, this.col));
			if(this.col!=0 && board.board[this.row-1][this.col-1]!=null && board.board[this.row-1][this.col-1].color!=0)
				points.add(new Point(this.row - 1, this.col-1));
			if(this.col!=7 && board.board[this.row-1][this.col+1]!=null&& board.board[this.row-1][this.col+1].color!=0)
				points.add(new Point(this.row - 1, this.col+1));
			if(this.row==6)
				points.add(new Point(this.row-2,this.col));
		}
		if (points.isEmpty())
			return null;
		else {
			temp = new Point[points.size()];
			for(int i=0;i<points.size();i++)
				temp[i]=points.get(i);
			return temp;
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canTakePiece(ChessPiece[][] board, int endX, int endY) {
		// TODO Auto-generated method stub
		return false;
	}

}