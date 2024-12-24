package Model;

import java.util.ArrayList;
import java.util.List;

public class Chariot extends ChessPiece {
	private int value = 50;
	private List<Tile> listCanMove;
	int chariot_table[][] = { { 9, 9, 9, 9, 10, 10, 9, 9, 9 }, { 9, 9, 9, 9, 10, 10, 9, 9, 9 },
			{ 9, 9, 9, 9, 10, 10, 9, 9, 9 }, { 9, 9, 9, 9, 10, 10, 9, 9, 9 }, { 9, 9, 9, 9, 10, 10, 9, 9, 9 },
			{ 9, 9, 9, 9, 10, 10, 9, 9, 9 }, { 9, 9, 9, 9, 10, 10, 9, 9, 9 }, { 9, 9, 9, 9, 10, 10, 9, 9, 9 },
			{ 9, 9, 9, 9, 10, 10, 9, 9, 9 }, { 9, 9, 9, 9, 10, 10, 9, 9, 9 } };
	int position_avantage;

	public Chariot(boolean color) {
		super(color);
		this.type = "Chariot";
		listCanMove = new ArrayList<>();
		position_avantage = 0;
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		if (i + 1 < board.length) {
			for (int k = i + 1; k < board.length; k++) {
				if (board[k][j].getPiece() == null) {
					listCanMove.add(board[k][j]);
					position_avantage = chariot_table[j][k];
				} else {
					if (board[k][j].getPiece().color != this.color) {
						listCanMove.add(board[k][j]);
						position_avantage = chariot_table[j][k];

					}
					break;
				}
			}
		}
		if (i - 1 >= 0) {
			for (int k = i - 1; k >= 0; k--) {
				if (board[k][j].getPiece() == null) {
					listCanMove.add(board[k][j]);
					position_avantage = chariot_table[j][k];
				} else {
					if (board[k][j].getPiece().color != this.color) {
						listCanMove.add(board[k][j]);
						position_avantage = chariot_table[j][k];
					}
					break;
				}
			}
		}
		if (j + 1 < board[0].length) {
			for (int k = j + 1; k < board[0].length; k++) {
				if (board[i][k].getPiece() == null) {
					listCanMove.add(board[i][k]);
					position_avantage = chariot_table[k][i];
				} else {
					if (board[i][k].getPiece().color != this.color) {
						listCanMove.add(board[i][k]);
						position_avantage = chariot_table[k][i];
					}
					break;
				}
			}
		}
		if (j - 1 >= 0) {
			for (int k = j - 1; k >= 0; k--) {
				if (board[i][k].getPiece() == null) {
					listCanMove.add(board[i][k]);
					position_avantage = chariot_table[k][i];
				} else {
					if (board[i][k].getPiece().color != this.color) {
						listCanMove.add(board[i][k]);
						position_avantage = chariot_table[k][i];
					}
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

	@Override
	public ChessPiece clone() {
		// TODO Auto-generated method stub
		return new Chariot(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return position_avantage;
	}

}
