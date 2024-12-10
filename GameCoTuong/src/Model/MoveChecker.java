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
			
				temp.checkPattern(move,gBoard.board);
				if (!move.isValid()) {
					this.legal = false;
				}
				if(checkAttack(move)&&move.isValid()&&gBoard.isPlayer1Turn==temp.color) {
					gBoard.attack(move);
				}
				gBoard.heuristic();
			}

		}
		private boolean checkAttack(Move move2) {
			// TODO Auto-generated method stub
			return (gBoard.getBoard()[move.getFinalX()][move.getFinalY()].getPiece())!=null;
		}


		public boolean isLegal() {
			return this.legal;
		}
	}