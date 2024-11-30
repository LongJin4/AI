package Model;

public class Horse extends ChessPiece {

	public Horse(boolean color) {
		super(color);
		this.type = "Horse";
	}

	@Override
	public void checkPattern(Move move, Tile[][] board) {
		// TODO Auto-generated method stub
		super.checkPattern(move, board);
//		 thêm kiểm tra logic quân mã
		System.out.println(move.getOriginX()+"x"+move.getFinalX());
		System.out.println(board[(move.getOriginX() + move.getFinalX()) / 2][move.getOriginY()].getPiece() != null);
		if (!((Math.abs(move.getDx()) == 1 && Math.abs(move.getDy()) == 2
				&& board[move.getOriginX()][(move.getOriginY() + move.getFinalY()) / 2].getPiece() == null))
				|| (Math.abs(move.getDx()) == 2 && Math.abs(move.getDy()) == 1
						&&board[(move.getOriginX() + move.getFinalX()) / 2][move.getOriginY()].getPiece() == null )) {
			
			move.setValid(false);
		}

	}

}
