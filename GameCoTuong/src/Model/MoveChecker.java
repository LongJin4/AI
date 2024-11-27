package Model;

//Tạo 1 checker để kiểm tra lớp move (chứa board để lấy tọa độ quân trên bàn cờ)
	public class MoveChecker {
		private Move move;
		private ChessBoard gBoard;
		private boolean legal;
		
		
		public MoveChecker( ChessBoard gBoard,Move move) {
			this.move = move;
			this.gBoard = gBoard;
			this.legal = true;
			CheckPiece();

		}

		private void CheckPiece() {
			ChessPiece temp = gBoard.getTile(move.getOriginX(), move.getOriginY()).getPiece();

			if (temp == null) {
				this.legal = false;
			} else {
				temp.checkPattern(move);
				if (!move.isValid()) {
					this.legal = false;
				}
			}

		}
		public boolean isLegal() {
			return this.legal;
		}
	}