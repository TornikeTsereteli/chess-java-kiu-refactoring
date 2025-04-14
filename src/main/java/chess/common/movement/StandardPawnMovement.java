package chess.common.movement;

import chess.model.Board;
import chess.model.Piece;
import chess.model.Square;
import chess.model.enums.PieceColor;

import java.util.LinkedList;
import java.util.List;

public class StandardPawnMovement implements MovementStrategy{


    private final Piece pawn;

    private final boolean wasMoved;

    public StandardPawnMovement(Piece pawn, boolean wasMoved) {
        this.pawn = pawn;
        this.wasMoved = wasMoved;
    }


    @Override
    public List<Square> getLegalMoves(Board chessBoard) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();

        Square[][] board = chessBoard.getSquareArray();
        Square position = pawn.getPosition();

        int x = position.getPosition().getX();
        int y = position.getPosition().getY();
        PieceColor c = pawn.getColor();

        if (c == PieceColor.BLACK) {
            if (!wasMoved) {
                if (!board[y+2][x].isOccupied()) {
                    legalMoves.add(board[y+2][x]);
                }
            }

            if (y+1 < 8) {
                if (!board[y+1][x].isOccupied()) {
                    legalMoves.add(board[y+1][x]);
                }
            }

            if (x+1 < 8 && y+1 < 8) {
                if (board[y+1][x+1].isOccupied()) {
                    legalMoves.add(board[y+1][x+1]);
                }
            }

            if (x-1 >= 0 && y+1 < 8) {
                if (board[y+1][x-1].isOccupied()) {
                    legalMoves.add(board[y+1][x-1]);
                }
            }
        }

        if (c == PieceColor.WHITE) {
            if (!wasMoved) {
                if (!board[y-2][x].isOccupied()) {
                    legalMoves.add(board[y-2][x]);
                }
            }

            if (y-1 >= 0) {
                if (!board[y-1][x].isOccupied()) {
                    legalMoves.add(board[y-1][x]);
                }
            }

            if (x+1 < 8 && y-1 >= 0) {
                if (board[y-1][x+1].isOccupied()) {
                    legalMoves.add(board[y-1][x+1]);
                }
            }

            if (x-1 >= 0 && y-1 >= 0) {
                if (board[y-1][x-1].isOccupied()) {
                    legalMoves.add(board[y-1][x-1]);
                }
            }
        }

        return legalMoves;
    }


}
