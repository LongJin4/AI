package Model;

import java.awt.Graphics2D;
import java.io.IOException;

public abstract class ChessPiece {
	int x, y, width, height;
	boolean color;// red=true black= false

	public ChessPiece(int x, int y, int width, int height, boolean color) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public abstract void draw(Graphics2D g2) throws IOException;
}
