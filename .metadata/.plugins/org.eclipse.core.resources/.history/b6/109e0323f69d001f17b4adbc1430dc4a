package Model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class General extends ChessPiece{
	//King
	File image;
	String path = "D:\\Java_Project\\AI\\GameCoTuong\\src\\chess_pieces_Image\\";

	public General(int x, int y, int width, int height, boolean color) {
		super(x, y, width, height, color);
		// TODO Auto-generated constructor stub
		if (color) {
			path += "b";
		} else {
			path += "r";
		}
		path += "K.png";
		image = new File(path);
	}

	@Override
	public void draw(Graphics2D g2) throws IOException {
		// TODO Auto-generated method stub

		BufferedImage boardImage = ImageIO.read(image);
		g2.drawImage(boardImage, x, y, width, height, null);
	}

}
