package View;

import Model.ChessBoard;
import Model.ChessPiece;
import Model.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameView extends JPanel {
	private ChessBoard gBoard;
	private Tile selectedTile;

	public GameView(ChessBoard gBoard) {
		this.gBoard = gBoard;
		this.setPreferredSize(new Dimension(800, 900));
		this.setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		try {
			// Draw the chessboard
			gBoard.draw(g2);
			// Highlight selected tile
			if (selectedTile != null) {
				highlightTile(g2, selectedTile, Color.YELLOW);
			}

			// Draw the pieces
			drawPieces(g2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateView() {
		repaint(); // Repaint the panel when the board state changes
	}

	private void drawPieces(Graphics2D g2) throws IOException {
		Tile[][] board = gBoard.getBoard();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Tile tile = board[i][j];
				ChessPiece piece = tile.getPiece();
				if (piece != null) {

					// Draw the piece image
					BufferedImage pieceImage = ImageIO.read(piece.getImage());
					g2.drawImage(pieceImage, tile.getX(), tile.getY(), gBoard.getTileSize(), gBoard.getTileSize(),
							null);
				}
			}
		}
	}

	private void highlightTile(Graphics2D g2, Tile tile, Color color) {
		g2.setColor(color);
		int x = tile.getX();
		int y = tile.getY();
		int size = gBoard.getTileSize();
		g2.fillRect(x, y, size, size);
	}

	public void clearSelectedTile() {
		this.selectedTile = null;
		repaint();
	}

	public void setSelectedTile(Tile tile) {
		this.selectedTile = tile;
		repaint();
	}
}
