package chess.common.movement;

import chess.model.Board;
import chess.model.Piece;
import chess.model.Square;

import java.util.LinkedList;
import java.util.List;

public class StandardKnightMovement implements MovementStrategy{

    private final Piece knight;

    public StandardKnightMovement(Piece knight) {
        this.knight = knight;
    }

    @Override
    public List<Square> getLegalMoves(Board chessBoard) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = chessBoard.getSquareArray();
        Square position = knight.getPosition();


        int x = position.getPosition().getX();
        int y = position.getPosition().getY();

        for (int i = 2; i > -3; i--) {
            for (int k = 2; k > -3; k--) {
                if(Math.abs(i) == 2 ^ Math.abs(k) == 2) {
                    if (k != 0 && i != 0) {
                        try {
                            legalMoves.add(board[y + k][x + i]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }

        return legalMoves;

    }


}
