package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cannon extends ChessPiece {
	private int value = 35;
	private List<Tile> listCanMove;
	int[][] cannon_table = { { 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 5, 5, 4, 4, 4 },
			{ 5, 5, 6, 6, 6, 6, 6, 5, 5 }, { 6, 6, 7, 8, 8, 8, 7, 6, 6 }, { 6, 6, 7, 8, 8, 8, 7, 6, 6 },
			{ 5, 5, 6, 6, 6, 6, 6, 5, 5 }, { 4, 4, 4, 4, 5, 5, 4, 4, 4 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3 } };
	int position_avantage;
	public Cannon(boolean color) {
		super(color);
		this.type = "Cannon";
		listCanMove = new ArrayList<>();
		position_avantage=0;
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		int countUP = 0, countDown = 0, countLeft = 0, countRight = 0;
		if (i + 1 < board.length) {
			for (int k = i + 1; k < board.length; k++) {
				if (board[k][j].getPiece() == null) {
					if (countUP == 0) {
						listCanMove.add(board[k][j]);
						position_avantage= cannon_table[j][k];
					}
				} else {
					if (countUP == 1) {
						if ((board[k][j].getPiece().color != this.color)) {
							listCanMove.add(board[k][j]);
							position_avantage= cannon_table[j][k];
							countUP = 0;
						}
						break;
					}
					countUP++;

				}
			}
		}
		if (i - 1 >= 0) {
			for (int k = i - 1; k >= 0; k--) {
				if (board[k][j].getPiece() == null) {
					if (countDown == 0) {
						listCanMove.add(board[k][j]);
						position_avantage= cannon_table[j][k];
					}
				} else {
					if (countDown == 1) {
						if (board[k][j].getPiece().color != this.color) {
							listCanMove.add(board[k][j]);
							position_avantage= cannon_table[j][k];
							countDown = 0;
						}
						break;
					}
					countDown++;
				}
			}
		}
		if (j + 1 < board[0].length) {
			for (int k = j + 1; k < board[0].length; k++) {
				if (board[i][k].getPiece() == null) {
					if (countLeft == 0) {
						listCanMove.add(board[i][k]);
						position_avantage= cannon_table[k][i];
					}
				} else {
					if (countLeft == 1) {
						if (board[i][k].getPiece().color != this.color) {
							listCanMove.add(board[i][k]);
							position_avantage= cannon_table[k][i];
							countLeft = 0;
						}
						break;
					}
					countLeft++;

				}
			}
		}
		if (j - 1 >= 0) {
			for (int k = j - 1; k >= 0; k--) {
				if (board[i][k].getPiece() == null) {
					if (countRight == 0) {
						listCanMove.add(board[i][k]);
						position_avantage= cannon_table[k][i];
					}
				} else {
					if (countRight == 1) {
						if (board[i][k].getPiece().color != this.color) {
							listCanMove.add(board[i][k]);
							position_avantage= cannon_table[k][i];
							countRight = 0;
						}
						break;
					}
					countRight++;

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

	@Override
	public ChessPiece clone() {
		// TODO Auto-generated method stub
		return new Cannon(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return position_avantage;
	}
}
