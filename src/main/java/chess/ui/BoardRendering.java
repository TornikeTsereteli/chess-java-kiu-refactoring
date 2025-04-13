package chess.ui;

import chess.controller.GameController;
import chess.model.*;
import chess.model.enums.PieceColor;
import chess.ui.handler.BoardMouseHandler;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardRendering extends JPanel{
    private final Board board;
    @Setter
    private int currX, currY;

    private final GameController gameController;

    public BoardRendering(Board board, GameWindow gameWindow) {
        this.board = board;
        this.gameController = new GameController(board, gameWindow);

        setLayout(new GridLayout(8, 8, 0, 0));
        setPreferredSize(new Dimension(400, 400));
        MouseAdapter mouseAdapter = new BoardMouseHandler(gameController,this);
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);

        drawInitialSquares();
    }

    private void drawInitialSquares() {
        Square[][] squares = board.getSquareArray();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                add(new SquareRendering(squares[y][x]));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Square[][] squares = board.getSquareArray();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                squares[y][x].setDisplay(true);
            }
        }

        Piece currPiece = board.getCurrPiece();
        if (currPiece != null) {
            if ((currPiece.getColor() == PieceColor.WHITE && board.isWhiteTurn()) ||
                    (currPiece.getColor() == PieceColor.BLACK && !board.isWhiteTurn())) {

                Image img = currPiece.getImage();
                if (img != null) {
                    g.drawImage(img, currX, currY, null);
                }
            }
        }
    }


}
