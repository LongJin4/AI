package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AIMove {

	public int minimax(boolean isRed, ChessBoard board, int depth, int alpha, int beta) {
		if (depth == 0)
			return board.heuristic();
		if (isRed) {// red turn
			int tmp = -999999999;
			List<Move> possibleMoves = makeRandomMoves(board, true);// tạo danh sách các nước đi hợp lệ của quân đỏ
			for (Move move : possibleMoves) {// duyệt danh sách nước đi lấy nước con
				ChessBoard branchBoard = simulateMove(board, move);// tạo bàn cờ giả lập nước đi nhánh con
				int advantageValue = minimax(false, branchBoard, depth - 1, alpha, beta);// đệ quy tính giá trị lợi thế
																							// nước con
				if (advantageValue > tmp) {
					tmp = advantageValue;

				}
				if (alpha < tmp) {
					alpha = tmp;
				}
				if (beta <= alpha)
					break;
			}
			return tmp;
		} else {
			int tmp = 999999999;
			List<Move> possibleMoves = makeRandomMoves(board, false);// quân đen
			for (Move move : possibleMoves) {
				ChessBoard branchBoard = simulateMove(board, move);
				int advantageValue = minimax(true, branchBoard, depth - 1, alpha, beta);

				if (advantageValue < tmp) {
					tmp = advantageValue;
				}
				if (beta > tmp) {
					beta = tmp;
				}
				if (beta <= alpha)
					break;
			}
			return tmp;
		}
	}

	private ChessBoard simulateMove(ChessBoard board, Move move) {
		// Tạo bản sao bàn cờ
		ChessBoard simulatedBoard = board.clone();
		simulatedBoard.doMove(move);
		return simulatedBoard;
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
					branchMoves.addAll(makeLegalMovesList(i, j, piece));
				}
			}
		}
		return branchMoves;
	}

	private List<Move> makeLegalMovesList(int i, int j, ChessPiece piece) {
		// TODO Auto-generated method stub
		List<Move> listMove = new ArrayList<>();
		for (Tile tile : piece.getListCanmove()) {
			int x = (tile.getX() - 33 + 67 / 2) / 67;
			int y = (tile.getY() - 99 + 67 / 2) / 67;
			listMove.add(new Move(i, j, x, y));
		}
		return listMove;
	}

	/**
	 * lấy nước đi tốt nhất
	 * 
	 * @param board
	 * @param depth
	 * @return
	 */
	public void getBestMove(boolean isRed, ChessBoard board, int depth) {
		Move bestMove = null;
		long startTime = System.nanoTime(); // Bắt đầu tính thời gian
		int tmp, bestScore ;
		int alpha = -999999999;
		int beta = 999999999;
		if (isRed)
			tmp = -999999999;
		else
			tmp = 999999999;
		// Tạo danh sách các nước đi hợp lệ
		List<Move> possibleMoves = makeRandomMoves(board, isRed);

		for (Move move : possibleMoves) {
			// Giả lập bàn cờ sau nước đi
			ChessBoard branchBoard = simulateMove(board, move);

			// Tính giá trị Minimax của nước đi
			int currentAdvantageValue = minimax(!isRed, branchBoard, depth - 1, alpha, beta);

			// Cập nhật nước đi tốt nhất dựa trên giá trị Minimax
			if ((isRed && currentAdvantageValue > tmp) || (!isRed && currentAdvantageValue < tmp)) {
				tmp = currentAdvantageValue;
				bestMove = move;
			}
			// Cập nhật giá trị alpha hoặc beta
	        if (isRed) {
				if(alpha > tmp) {
					alpha = tmp;
				}
	        } else {
	            if(beta < tmp) {
	            	beta = tmp;
	            }
	        }

	        // Cắt tỉa nếu cần
	        if (beta <= alpha) {
	            break;
	        }
		}
		board.doMove(bestMove);
		int totalRed = 0;
		int totalBlack = 0;
		for (ChessPiece piece : board.listPieceRedAlive) {
			totalRed += piece.heuristic();
		}
		for (ChessPiece piece : board.listPieceBlAlive) {
			totalBlack += piece.heuristic();
		}
		long endTime = System.nanoTime(); // Kết thúc tính thời gian
		long duration = endTime - startTime; // Tính toán thời gian đã qua

		System.out.println("Best move calculated in: " + (duration / 1_000_000) + " ms");
		System.out.println("Black " + totalBlack);
		System.out.println("red " + totalRed);
		System.out.println(board.heuristic());
	}

}
