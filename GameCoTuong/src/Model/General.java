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
			addMove(i + 1, j, board);

		}
		if (i - 1 >= 3) {
			addMove(i - 1, j, board);

		}

		if (this.color) {

			if (j - 1 >= 0) {
				addMove(i, j - 1, board);

			}
			if (j + 1 <= 2) {
				addMove(i, j + 1, board);

			}
		} else {

			if (j - 1 >= 7) {
				addMove(i, j - 1, board);

			}
			if (j + 1 <= 9) {
				addMove(i, j + 1, board);

			}
		}
		// check face to face general
		if (this.color) {
			for (int k = j+1; k < board.length; k++) {
				if (board[i][k].getPiece() != null) {
					if (board[i][k].getPiece() instanceof General) {
						listCanMove.add(board[i][k]);
					}
					break;
				}
			}
		} else {
			for (int k = j-1; k >= 0; k--) {
				if (board[i][k].getPiece() != null) {
					if (board[i][k].getPiece() instanceof General) {
						System.out.println(i+" "+k);
						listCanMove.add(board[i][k]);
					}
					break;
				}
			}
		}
	}

	// thêm 1 nước đi hợp lệ nếu ô đó không có quân cờ nào hoặc tồn tại quân cờ đối
	// phương
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

//	danh sách nước đi hợp lệ của quân cờ
	@Override
	protected List<Tile> getListCanmove() {
		// TODO Auto-generated method stub
		return listCanMove;
	}

// sao chép quân cờ mới
	@Override
	public ChessPiece clone() {
		// TODO Auto-generated method stub
		return new General(color);
	}

// tính toán xem vị trí có lợi thế không
	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
