package Main;

import Controller.Controller;
import Model.ChessBoard;
import View.GameView;

public class XiangqiGame {
    public static void main(String[] args) {
        // Create model, view, and controller
        ChessBoard board = new ChessBoard(0,0);
        GameView view = new GameView(board);
        Controller controller = new Controller(board, view);

        // Start the game
        controller.startGame();
    }
}
