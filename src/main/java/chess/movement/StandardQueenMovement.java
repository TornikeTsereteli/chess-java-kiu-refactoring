package chess.movement;

import chess.model.Board;
import chess.model.Piece;
import chess.model.Square;
import chess.util.MovementHelper;

import java.util.LinkedList;
import java.util.List;

public class StandardQueenMovement implements MovementStrategy{

    private final Piece piece;


    public StandardQueenMovement(Piece piece) {
        this.piece = piece;
    }

    @Override
    public List<Square> getLegalMoves(Board chessBoard) {
        LinkedList<Square> legalMoves = new LinkedList<>();
        Square[][] board = chessBoard.getSquareArray();
        Square position = piece.getPosition();
        int x = position.getXNum();
        int y = position.getYNum();


        int[] occups = MovementHelper.getLinearMoves(chessBoard, piece);

        for (int i = occups[0]; i <= occups[1]; i++) {
            if (i != y) legalMoves.add(board[i][x]);
        }

        for (int i = occups[2]; i <= occups[3]; i++) {
            if (i != x) legalMoves.add(board[y][i]);
        }

        List<Square> bMoves = MovementHelper.getDiagonalMoves(chessBoard, piece);

        legalMoves.addAll(bMoves);

        return legalMoves;
    }
}
