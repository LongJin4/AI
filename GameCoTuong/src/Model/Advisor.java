package Model;

import java.util.ArrayList;
import java.util.List;

public class Advisor extends ChessPiece {
	private int value = 25;
	private List<Tile> listCanMove;

	public Advisor(boolean color) {
		super(color);
		this.type = "Advisor";
		listCanMove = new ArrayList<>();
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		int up = j + 1;
		int down = j - 1;
		int left = i - 1;
		int right = i + 1;
		if (this.color) {
			if (down >= 0 && left >= 3)
				addmove(left,down,board);
			if (up <= 2 && left >= 3)
				addmove(left,up,board);
			if (down >= 0 && right <= 5)
				addmove(right,down,board);
			if (up <= 2 && right <= 5)
				addmove(right,up,board);
		} else {
			if (down >= 7 && left >= 3)
				addmove(left,down,board);
			if (up <= 9 && left >= 3)
				addmove(left,up,board);
			if (down >= 7 && right <= 5)
				addmove(right,down,board);
			if (up <= 9 && right <= 5)
				addmove(right,up,board);
		}
	}
// thêm 1 nước đi hợp lệ nếu ô đó không có quân cờ nào hoặc tồn tại quân cờ đối phương
	private void addmove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
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
		return new Advisor(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
