package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChessBoard {
    private Tile[][] board;
    private File image;
    private int tileSize;

    public ChessBoard() {
        board = new Tile[10][9]; // 10 hàng 9 cột
        image = new File("src\\Board_Image\\Xiangqi_board.png");
        tileSize = 100;
       

        initialBoard();
    }

    private void initialBoard() {
        // Tạo mảng ban đầu
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
            	//tọa độ x,y sao cho khớp 1 ô là vị trí quân trên đường của bàn cờ
                int x = j * tileSize; 
                int y = i * tileSize; 
                board[i][j] = new Tile(x, y+tileSize, tileSize); 
            }
        }
    }

    public void draw(Graphics2D g2) throws IOException {
        // Vẽ ảnh bàn cờ image
        BufferedImage boardImage = ImageIO.read(image);
        g2.drawImage(boardImage, 0, 0, null);

        // Vẽ các ô 
        //g2.setColor(new java.awt.Color(204,85,34,255)); // phối màu chung với bàn cờ
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Tile tile = board[i][j];
                g2.drawRect(tile.getX(), tile.getY(), tile.getSize(), tile.getSize());
            }
        }
    }
}
