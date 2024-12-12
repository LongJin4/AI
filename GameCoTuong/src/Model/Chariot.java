package Model;

import java.util.ArrayList;
import java.util.List;

public class Chariot extends ChessPiece {
	private int value = 50;
	private List<Tile> listCanMove;

	public Chariot(boolean color) {
		super(color);
		this.type = "Chariot";
		listCanMove = new ArrayList<>();
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		if (i + 1 < board.length) {
			for (int k = i + 1; k < board.length; k++) {
				if (board[k][j].getPiece() == null) {
					listCanMove.add(board[k][j]);
				} else {
					listCanMove.add(board[k][j]);
					break;
				}
			}
		}
		if (i - 1 >= 0) {
			for (int k = i - 1; k >= 0; k--) {
				if (board[k][j].getPiece() == null) {
					listCanMove.add(board[k][j]);
				} else {
					listCanMove.add(board[k][j]);
					break;
				}
			}
		}
		if (j + 1 < board[0].length) {
			for (int k = j + 1; k < board[0].length; k++) {
				if (board[i][k].getPiece() == null) {
					listCanMove.add(board[i][k]);
				} else {
					listCanMove.add(board[i][k]);
					break;
				}
			}
		}
		if (j - 1 >= 0) {
			for (int k = j - 1; k >= 0; k--) {
				if (board[i][k].getPiece() == null) {
					listCanMove.add(board[i][k]);
				} else {
					listCanMove.add(board[i][k]);
					break;
				}
			}
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

}
