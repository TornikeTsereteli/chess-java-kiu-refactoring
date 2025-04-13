package chess.movement;

import chess.model.Board;
import chess.model.Piece;
import chess.model.Square;
import chess.util.MovementHelper;

import java.util.LinkedList;
import java.util.List;

public class StandardRookMovement implements MovementStrategy{

    private final Piece rook;

    public StandardRookMovement(Piece rook) {
        this.rook = rook;
    }


    @Override
    public List<Square> getLegalMoves(Board chessBoard) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();

        Square[][] board = chessBoard.getSquareArray();
        Square position = rook.getPosition();

        int x = position.getXNum();
        int y = position.getYNum();

        int[] occups = MovementHelper.getLinearMoves(chessBoard,rook);

        for (int i = occups[0]; i <= occups[1]; i++) {
            if (i != y) legalMoves.add(board[i][x]);
        }

        for (int i = occups[2]; i <= occups[3]; i++) {
            if (i != x) legalMoves.add(board[y][i]);
        }

        return legalMoves;
    }
}
