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
		System.out.println(i+" "+j);
		System.out.println(up+"down "+ down+"left "+left+"right "+right);
		if (this.color) {
			if (down >= 0 &&left >=0&&board[left+1][down+1].getPiece()==null) {
				addmove(left, down, board);}
			if (up <= 5 && left >= 0&&board[left+1][up-1].getPiece()==null)
				addmove(left, up, board);
			if (down >= 0 && right <= board.length&&board[right-1][down+1].getPiece()==null)
				addmove(right, down, board);
			if (up <= 5 && right <= board.length&&board[right-1][up-1].getPiece()==null)
				addmove(right, up, board);
		} else {
			if (down>= 5 && left >= 0&&board[left+1][down+1].getPiece()==null) {
				addmove(left, down, board);
				}
			if (up <= 9 && left >= 0&&board[left+1][up-1].getPiece()==null) {
				addmove(left, up, board);}
			if (down >= 5 && right<= 9&&(board[right-1][down+1].getPiece()==null)) {
				addmove(right, down, board);
			}	
				
			if (up <= 9 && right <= board.length&&board[right-1][up-1].getPiece()==null) {
				addmove(right, up, board);
			
				}
				
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
		return new Elephant(color);
	}

	@Override
	public int getPosition_avantage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
