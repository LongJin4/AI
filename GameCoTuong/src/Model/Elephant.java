package Model;

import java.util.ArrayList;
import java.util.List;

public class Elephant extends ChessPiece {
	private int value = 20;
	private List<Tile> listCanMove;

	public Elephant(boolean color) {
		super(color);
		this.type = "Elephant";
		listCanMove = new ArrayList<>();
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		int up=j+2;
		int down=j-2;
		int left=i-2;
		int right=i+2;
		if (this.color) {
			if (down >= 0 &&left >=0)
				listCanMove.add(board[left][down]);
			if (up <= 5 && left >= 0)
				listCanMove.add(board[left][up]);
			if (down >= 0 && right <= board.length)
				listCanMove.add(board[right][down]);
			if (up <= 5 && right <= board.length)
				listCanMove.add(board[right][up]);
		} else {
			if (down>= 5 && left >= 0)
				listCanMove.add(board[left][down]);
			if (up <= 9 && left >= 0)
				listCanMove.add(board[left][up]);
			if (down >= 5 && right<= board.length) {
				listCanMove.add(board[right][down]);}
			if (up <= 9 && right <= board.length)
				listCanMove.add(board[right][up]);
		}
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	protected List<Tile> getListCanmove() {
		// TODO Auto-generated method stub
		return listCanMove;
	}

	@Override
	public ChessPiece clone() {
		// TODO Auto-generated method stub
		return new Elephant(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
