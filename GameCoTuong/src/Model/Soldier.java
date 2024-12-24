package Model;

import java.util.ArrayList;
import java.util.List;

public class Soldier extends ChessPiece {
	private int value = 10;
	private List<Tile> listCanMove;
	int[][] solider_table = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 1, 1, 1, 2, 2, 2, 1, 1, 1 }, { 2, 2, 2, 3, 3, 3, 2, 2, 2 }, { 3, 3, 3, 4, 4, 4, 3, 3, 3 },
			{ 4, 4, 4, 5, 5, 5, 4, 4, 4 }, { 5, 5, 5, 6, 6, 6, 5, 5, 5 }, { 6, 6, 6, 7, 7, 7, 6, 6, 6 },
			{ 7, 7, 7, 8, 8, 8, 7, 7, 7 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	int position_avantage;

	public Soldier(boolean color) {
		super(color);
		this.type = "Soldier";
		listCanMove = new ArrayList<>();
		position_avantage = 0;
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		boolean isCrossed = false;
		if (this.color) {
			if (j + 1 < board[0].length) {
				addMove(i, j+1, board);
				position_avantage = solider_table[j + 1][i];
			}
			if (j > 5)
				isCrossed = true;

		} else {
			if (j - 1 >= 0) {
				addMove(i, j-1, board);
				position_avantage = solider_table[j - 1][i];
			}
			if (j < 5)
				isCrossed = true;

		}
		if (isCrossed) {
			if (i + 1 < 9) {
				addMove(i+1, j, board);
				position_avantage = solider_table[j][i + 1];
			}
			if (i - 1 >= 0) {
				addMove(i-1, j, board);
				position_avantage = solider_table[j][i - 1];
			}
		}
	}
	// thêm 1 nước đi hợp lệ nếu ô đó không có quân cờ nào hoặc tồn tại quân cờ đối phương
	private void addMove(int i, int j, Tile[][] board) {
		if (board[i][j].getPiece() == null) {
			listCanMove.add(board[i][j]);
		} else {
			if (board[i][j].getPiece().color != color)
				listCanMove.add(board[i][j]);
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
		return new Soldier(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return position_avantage;
	}

}
