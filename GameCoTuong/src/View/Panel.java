package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Controller.Controller;
import Controller.IController;
import Model.ChessBoard;

public class Panel extends JPanel {
	BufferedImage image;
	IController controll = new Controller();

	public Panel() {
		image = new BufferedImage(Frame.frame_Width, Frame.frame_Height, BufferedImage.TYPE_INT_RGB);
		controll = new Controller();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("x:" + e.getX());
				System.out.println("y:" + e.getY());
			}
		});
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g); // Vẽ thành phần mặc định trước

		// Ép kiểu Graphics thành Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		try {
			controll.draw(g2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
