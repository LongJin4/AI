package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cannon extends ChessPiece {
	private int value = 35;
	private List<Tile> listCanMove;
	int[][] cannonPositionAdvantage = {
		    {1, 0, 1, 0, 2, 0, 1, 0, 1}, // Hàng 0: Các góc cho đường bắn
		    {0, 1, 0, 0, 2, 0, 0, 1, 0}, // Hàng 1: Hỗ trợ trung lộ
		    {0, 0, 0, 0, 1, 0, 0, 0, 0}, // Hàng 2: Trống để di chuyển
		    {0, 1, 0, 0, 1, 0, 0, 1, 0}, // Hàng 3: Vị trí bắn phá tốt
		    {0, 0, 0, 0, 1, 0, 0, 0, 0}, // Hàng 4: Hỗ trợ di chuyển
		    {0, 0, 0, 0, 1, 0, 0, 0, 0}, // Hàng 5: Hỗ trợ di chuyển
		    {0, 1, 0, 0, 1, 0, 0, 1, 0}, // Hàng 6: Vị trí bắn phá tốt
		    {0, 0, 0, 0, 2, 0, 0, 0, 0}, // Hàng 7: Trung lộ cho Pháo
		    {1, 0, 1, 0, 2, 0, 1, 0, 1}, // Hàng 8: Vị trí khởi đầu và thuận lợi
		    {0, 0, 0, 0, 1, 0, 0, 0, 0}, // Hàng 9: Bảo vệ vùng Tướng
		};
	public Cannon(boolean color) {
		super(color);
		this.type = "Cannon";
		listCanMove = new ArrayList<>();
	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		int countUP = 0, countDown = 0, countLeft = 0, countRight = 0;
		if (i + 1 < board.length) {
			for (int k = i + 1; k < board.length; k++) {
				if (board[k][j].getPiece() == null) {
					listCanMove.add(board[k][j]);
				} else {
					if (countUP == 1 && (board[k][j].getPiece().color != this.color)) {
						listCanMove.add(board[k][j]);
						break;
					}
					countUP++;

				}
			}
		}
		if (i - 1 >= 0) {
			for (int k = i - 1; k >= 0; k--) {
				if (board[k][j].getPiece() == null) {
					listCanMove.add(board[k][j]);
				} else {
					if (countDown == 1) {
						System.out.println("dcm");
						listCanMove.add(board[k][j]);
						break;
					}
					countDown++;
				}
			}
		}
		if (j + 1 < board[0].length) {
			for (int k = j + 1; k < board[0].length; k++) {
				if (board[i][k].getPiece() == null) {
					listCanMove.add(board[i][k]);
				} else {
					if (countLeft == 1) {
						listCanMove.add(board[i][k]);
						break;
					}
					countLeft++;

				}
			}
		}
		if (j - 1 >= 0) {
			for (int k = j - 1; k >= 0; k--) {
				if (board[i][k].getPiece() == null) {
					listCanMove.add(board[i][k]);
				} else {
					if (countRight == 1) {
						listCanMove.add(board[i][k]);
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
		return value ;
	}

	@Override
	protected List<Tile> getListCanmove() {
		// TODO Auto-generated method stub
		return listCanMove;
	}


}
