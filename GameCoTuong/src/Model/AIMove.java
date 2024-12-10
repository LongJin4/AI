package Model;

import java.util.ArrayList;
import java.util.List;

public class AIMove {

	public int hueristic(ChessBoard board) {
		int advantageValue = 0; // số dương -> đỏ ,âm -> đen có lợi thế
//		advantage = ?;
		return advantageValue;
	}

	public int minimax(boolean isRed, ChessBoard board, int depth) {
		if (depth == 0)
			return hueristic(board);
		if (isRed) {// red turn
			int tmp = -999999999;
			List<Move> possibleMoves = makeRandomMoves(board, true);// tạo danh sách các nước đi hợp lệ của quân đỏ
			for (Move move : possibleMoves) {// duyệt danh sách nước đi lấy nước con
				ChessBoard branchBoard = simulateMove(board, move);// tạo bàn cờ giả lập nước đi nhánh con
				int advantageValue = minimax(false, branchBoard, depth--);// đệ quy tính giá trị lợi thế nước con
				if (advantageValue > tmp) {
					tmp = advantageValue;
				}
			}
			return tmp;
		} else {
			int tmp = 999999999;
			List<Move> possibleMoves = makeRandomMoves(board, false);// quân đen
			for (Move move : possibleMoves) {
				ChessBoard branchBoard = simulateMove(board, move);
				int advantageValue = minimax(true, branchBoard, depth--);

				if (advantageValue < tmp) {
					tmp = advantageValue;
				}
			}
			return tmp;
		}
	}

	private ChessBoard simulateMove(ChessBoard board, Move move) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * hàm trả về danh sách chứa các nước con hợp lệ
	 */
	private List<Move> makeRandomMoves(ChessBoard board, boolean isRed) {
		// TODO Auto-generated method stub
		List<Move> branchMoves = new ArrayList<>();
		Tile[][] state = board.getBoard();
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				ChessPiece piece = state[i][j].getPiece();
				if (piece != null && piece.getColor() == isRed) {
					branchMoves.addAll(makeLegalMovesList(i, j, board));
				}
			}
		}
		return branchMoves;
	}

	private List<Move> makeLegalMovesList(int i, int j, ChessBoard board) {
		List<Move> legalMovesList = new ArrayList<>();
		Tile[][] state = board.getBoard();
		ChessPiece piece = state[i][j].getPiece();
		if (piece != null) {
			for (int x = 0; x < state.length; x++) {
				for (int y = 0; y < state[x].length; y++) {
					Move move = new Move(i, j, x, y);
					if (board.isMakeLegalMove(move)) { // Kiểm tra nước đi hợp lệ
						legalMovesList.add(move);
					}
				}
			}
		}
		return legalMovesList;
	}

	/**
	 * lấy nước đi tốt nhất
	 * @param board
	 * @param depth
	 * @return
	 */
	public Move getBestMove(boolean isRed, ChessBoard board, int depth) {
	    Move bestMove = null;
	    int tmp;
	    if(isRed) tmp = -999999999;
	    else tmp = 999999999;
	    // Tạo danh sách các nước đi hợp lệ
	    List<Move> possibleMoves = makeRandomMoves(board, isRed);

	    for (Move move : possibleMoves) {
	        // Giả lập bàn cờ sau nước đi
	        ChessBoard branchBoard = simulateMove(board, move);

	        // Tính giá trị Minimax của nước đi
	        int currentAdvantageValue = minimax(!isRed, branchBoard, depth - 1);

	        // Cập nhật nước đi tốt nhất dựa trên giá trị Minimax
	        if ((isRed && currentAdvantageValue > tmp) || (!isRed && currentAdvantageValue < tmp)) {
	        	tmp = currentAdvantageValue;
	            bestMove = move;
	        }
	    }

	    return bestMove;
	}

}
