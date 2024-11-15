package Controller;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import Model.ChessPiece;
import Model.Tile;

public interface IController {
	void draw(Graphics2D g2) throws IOException;

	ChessPiece select(int x, int y);

	void update() throws IOException;

	void move(ChessPiece chesspiece, int x, int y);
	

}
