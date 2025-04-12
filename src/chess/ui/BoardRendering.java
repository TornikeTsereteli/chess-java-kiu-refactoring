package chess.ui;

import chess.controller.GameController;
import chess.model.*;
import chess.model.enums.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BoardRendering extends JPanel implements MouseListener, MouseMotionListener {
    private final Board board;
    private int currX, currY;

    private final GameController gameController;

    public BoardRendering(Board board, GameWindow gameWindow) {
        this.board = board;
        this.gameController = new GameController(board, gameWindow);

        setLayout(new GridLayout(8, 8, 0, 0));
        setPreferredSize(new Dimension(400, 400));
        addMouseListener(this);
        addMouseMotionListener(this);

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
                new SquareRendering(squares[y][x]).paintComponent(g);
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

    @Override
    public void mousePressed(MouseEvent e) {
        currX = e.getX();
        currY = e.getY();

        SquareRendering squareRendering = (SquareRendering) getComponentAt(new Point(currX, currY));
        Square square = squareRendering.getSquare();

        gameController.handleMousePressed(square);

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        SquareRendering squareRendering = (SquareRendering) getComponentAt(new Point(e.getX(), e.getY()));
        Square targetSquare = squareRendering.getSquare();

        gameController.handleMouseReleased(targetSquare);

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currX = e.getX() - 24;
        currY = e.getY() - 24;
        repaint();
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
}
