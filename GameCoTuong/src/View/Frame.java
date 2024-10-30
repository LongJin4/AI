package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	public static final int frame_Width=800;
	public static final int frame_Height=800;
	JPanel mainPanel;
	public Frame() {
		mainPanel= new Panel();
		add(mainPanel);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Frame.frame_Width, frame_Height);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		Frame frame = new Frame();
	}
}
