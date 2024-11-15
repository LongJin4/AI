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
	IController controll;
	Listener listen;
	public Panel() throws IOException {
		image = new BufferedImage(Frame.frame_Width, Frame.frame_Height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2= image.createGraphics();
		controll = new Controller(g2);
		listen= new Listener(controll,this);
		this.addMouseListener(listen);
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g); // Vẽ thành phần mặc định trước
		 g.drawImage(image, 0, 0, null);
	}
	//ham nay de cap nhat lai gia tri va hinh anh 
	public void refresh() throws IOException {
		controll.update();
		repaint();
	}
	
}
