package Controller;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import Model.Advisor;
import Model.Cannon;
import Model.Chariot;
import Model.ChessBoard;
import Model.ChessPiece;
import Model.Elephant;
import Model.General;
import Model.Horse;
import Model.Solider;
import View.Frame;

public class Controller implements IController{
	ChessBoard board= new ChessBoard(0, 0, Frame.frame_Width, Frame.frame_Height);
	int[][] state= new int[9][8];
	int widthSquare= 133-43;
	int heightSquare=167-100;
	ArrayList<ChessPiece>list= new ArrayList<>();
	ChessPiece redAdvisor= new Advisor(0, 0, widthSquare, heightSquare, false);
	ChessPiece redCannon= new Cannon(0, 0, widthSquare, heightSquare, false);
	ChessPiece redLeftChariot= new Chariot(41, 97, widthSquare, heightSquare, false);
	ChessPiece redRightChariot= new Chariot(761, 99, widthSquare, heightSquare, false);
	ChessPiece redElephant= new Elephant(0, 0, widthSquare, heightSquare, false);
	ChessPiece redGeneral= new General(0, 0, widthSquare, heightSquare, false);
	ChessPiece redHorse= new Horse(0, 0, widthSquare, heightSquare, false);
	ChessPiece redSolider= new Solider(0, 0, widthSquare, heightSquare, false);
	@Override
	public void draw(Graphics2D g2) throws IOException {
		// TODO Auto-generated method stub
		board.draw(g2);
		redLeftChariot.draw(g2);
		redRightChariot.draw(g2);
	}

}
