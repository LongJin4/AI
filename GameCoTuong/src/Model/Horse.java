package Model;

import java.util.ArrayList;
import java.util.List;

public class Horse extends ChessPiece {
	private int value = 30;
	private List<Tile> listCanMove;
	int[][] horse_heuristic = {
		    {2, 3, 4, 4, 4, 4, 4, 3, 2},
		    {3, 4, 6, 6, 6, 6, 6, 4, 3},
		    {4, 6, 8, 8, 8, 8, 8, 6, 4},
		    {4, 6, 8, 10, 10, 10, 8, 6, 4},
		    {4, 6, 8, 10, 12, 10, 8, 6, 4},
		    {4, 6, 8, 10, 10, 10, 8, 6, 4},
		    {4, 6, 8, 8, 8, 8, 8, 6, 4},
		    {3, 4, 6, 6, 6, 6, 6, 4, 3},
		    {2, 3, 4, 4, 4, 4, 4, 3, 2},
		    {2, 2, 3, 3, 3, 3, 3, 2, 2}
		};
	int position_avantage;

	public Horse(boolean color) {
		super(color);
		this.type = "Horse";
		listCanMove = new ArrayList<>();
		position_avantage=0;
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		// Xóa các nước đi cũ trong list
		listCanMove.clear();

		// Các hướng di chuyển của quân mã
		int[][] directions = { { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 }, { -1, -2 }, { 1, -2 }, { -1, 2 }, { 1, 2 } };

		// Các vị trí "chốt mã" tương ứng với từng hướng di chuyển
		int[][] barriers = { { -1, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { 0, -1 }, { 0, -1 }, { 0, 1 }, { 0, 1 } };
		int boardHeight = board.length;
		int boardWidth = board[0].length;

		// Kiểm tra từng hướng di chuyển
		for (int k = 0; k < directions.length; k++) {
			int newI = i + directions[k][0];
			int newJ = j + directions[k][1];
			// Kiểm tra nếu ô chốt mã không bị cản
			int barrierI = i + barriers[k][0];
			int barrierJ = j + barriers[k][1];

			if (isInBounds(barrierI, barrierJ, boardHeight, boardWidth)
					&& board[barrierI][barrierJ].getPiece() == null) {
				// Kiểm tra nếu ô mới nằm trong giới hạn bàn cờ
				if (isInBounds(newI, newJ, boardHeight, boardWidth)) {
					// Kiểm tra nếu ô mới hợp lệ (trống hoặc có quân đối phương)
					if (board[newI][newJ].getPiece()==null) {
						listCanMove.add(board[newI][newJ]);
						position_avantage= horse_heuristic[newJ][newI];
					} else {
						if(board[newI][newJ].getPiece().color!=color) {
							listCanMove.add(board[newI][newJ]);
							position_avantage= horse_heuristic[newJ][newI];
						}
					}
					
				}
			}
		}
	}

	private boolean isInBounds(int i, int j, int height, int width) {
		return i >= 0 && i < height && j >= 0 && j < width;
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
		return new Horse(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return position_avantage;
	}

}
