package chess.controller;

import chess.model.Board;
import chess.model.Piece;
import chess.model.Square;
import chess.model.enums.PieceColor;
import chess.ui.GameWindow;

import java.util.List;

public class GameController {

    private final Board board;
    private final GameWindow gameWindow;

    public GameController(Board board, GameWindow gameWindow) {
        this.board = board;
        this.gameWindow = gameWindow;
    }

    public void handleMousePressed(Square square) {
        if (!square.isOccupied()) return;

        Piece piece = square.getOccupyingPiece();
        if ((piece.getColor() == PieceColor.BLACK && board.isWhiteTurn()) ||
                (piece.getColor() == PieceColor.WHITE && !board.isWhiteTurn())) {
            return;
        }

        board.setCurrPiece(piece);
        square.setDisplay(false);
    }

    public void handleMouseReleased(Square targetSquare) {
        Piece currPiece = board.getCurrPiece();
        if (currPiece == null) return;

        List<Square> legalMoves = currPiece.getLegalMoves(board);
        List<Square> allowed = board.getCheckmateDetector().getAllowableSquares(board.isWhiteTurn());

        if (legalMoves.contains(targetSquare) &&
                allowed.contains(targetSquare) &&
                board.getCheckmateDetector().testMove(currPiece, targetSquare)) {

            currPiece.move(targetSquare,board);
            board.getCheckmateDetector().update();

            if (board.getCheckmateDetector().blackCheckMated()) {
                gameWindow.checkmateOccurred(0);
            } else if (board.getCheckmateDetector().whiteCheckMated()) {
                gameWindow.checkmateOccurred(1);
            } else {
                board.toggleTurn();
            }
        } else {
            currPiece.getPosition().setDisplay(true);
        }

        board.setCurrPiece(null);
    }

}
