package Model;

import java.util.ArrayList;
import java.util.List;

public class General extends ChessPiece {

	private int value = 10000;
	private List<Tile> listCanMove;

	public General(boolean color) {
		super(color);
		this.type = "General";
		listCanMove = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Vua " + color;
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		if (i + 1 <= 5) {
			addAttack(i+1,j,board);
			listCanMove.add(board[i + 1][j]);
		}
		if (i - 1 >= 3) {
			addAttack(i-1,j,board);
			listCanMove.add(board[i - 1][j]);
		}

		if (this.color) {

			if (j - 1 >= 0) {
				addAttack(i,j-1,board);
				listCanMove.add(board[i][j - 1]);
			}
			if (j + 1 <= 2) {
				addAttack(i,j+1,board);
				listCanMove.add(board[i][j + 1]);
			}
		} else {

			if (j - 1 >= 7) {
				addAttack(i,j-1,board);
				listCanMove.add(board[i][j - 1]);
			}
			if (j + 1 <= 9) {
				addAttack(i,j+1,board);
				listCanMove.add(board[i][j + 1]);
			}
		}
		// check face to face general
		if (this.color) {
			for (int k = i; k < board.length; k++) {
				if (board[k][j].getPiece() != null) {
					if (board[k][j].getPiece() instanceof General) {
						listCanMove.add(board[k][j]);
					}
					break;
				}
			}
		}
	}

	private void addAttack(int i, int j, Tile[][] board) {
		if(board[i][j].getPiece()!=null&&board[i][j].getPiece().color!=color)
			listCanMove.add(board[i][j]);
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
		return new General(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
