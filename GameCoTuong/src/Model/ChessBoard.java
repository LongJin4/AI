package Model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import View.Frame;

public class ChessBoard {
	int x;
	int y;
	int width;
	int height;
	File image;

	public ChessBoard(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		image = new File("D:\\Java_Project\\AI\\GameCoTuong\\src\\Board_Image\\Xiangqi_board.png");
	}

	public void draw(Graphics2D g2) throws IOException {
		BufferedImage boardImage = ImageIO.read(image);
		g2.drawImage(boardImage, x, y, width, height, null);
	}
}
