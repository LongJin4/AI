package Controller;

import Model.*;
import View.GameView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Controller implements MouseListener {
	private ChessBoard gBoard;
	private GameView view;
	private int[] pressLoc = new int[2], releaseLoc = new int[2];
	private boolean pressed = false, pressIsValid = false;

	public Controller(ChessBoard gBoard, GameView view) {
		this.gBoard = gBoard;
		this.view = view;
		view.addMouseListener(this); // Attach the controller to the view
	}

	public void startGame() {
		JFrame frame = new JFrame("Xiangqi Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(view);
		frame.pack();
//		frame.setLocationRelativeTo(null);
		frame.setLocation(800, 0);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Translate screen coordinates to board indices
		int x = (e.getX() - ChessBoard.marginTop + gBoard.getTileSize() / 2) / gBoard.getTileSize();
		int y = (e.getY() - ChessBoard.marginLeft + gBoard.getTileSize() / 2) / gBoard.getTileSize();

		if (!pressed) {
			// First click: store the pressed piece location
			if (storePressed(x, y)) {
				pressed = true;
			}
		} else {
			// Second click: store release location and process move
			if (storeReleased(x, y)) {
				// Check if switching selection to another piece of the same side
				if (gBoard.getTile(pressLoc[0], pressLoc[1]).getPiece() != null
						&& gBoard.getTile(releaseLoc[0], releaseLoc[1]).getPiece() != null
						&& gBoard.getTile(pressLoc[0], pressLoc[1]).getPiece().getColor() == gBoard
								.getTile(releaseLoc[0], releaseLoc[1]).getPiece().getColor()) {
					storePressed(x, y);
				} else {
					// Perform the move
					pressed = false;
					Move move = new Move(pressLoc[0], pressLoc[1], releaseLoc[0], releaseLoc[1]);
					if (gBoard.isMakeLegalMove(move)) {
						view.updateView();
						System.out.println("Move performed: " + move);
						// After making a move, calculate and display the best moves
						AIMove aiMove = new AIMove();
						aiMove.getBestMove(gBoard.isPlayer1Turn(), gBoard, 3);
						

					} else {
						System.out.println("Invalid move: " + move);
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private boolean storePressed(int x, int y) {
		ChessPiece piece = gBoard.getTile(x, y).getPiece();
		if (piece == null) {
			pressIsValid = false;
			return false;
		} else {
			pressIsValid = true;
			pressLoc[0] = x;
			pressLoc[1] = y;
			System.out.println("Piece selected at: (" + x + ", " + y + ")");
			return true;
		}
	}

	private boolean storeReleased(int x, int y) {
		if (pressIsValid) {
			releaseLoc[0] = x;
			releaseLoc[1] = y;
			return true;
		}
		return false;
	}

}
