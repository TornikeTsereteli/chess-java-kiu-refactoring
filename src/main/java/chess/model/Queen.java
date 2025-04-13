package chess.model;

import chess.model.enums.PieceColor;
import chess.movement.MovementStrategy;
import chess.movement.StandardQueenMovement;

import java.util.LinkedList;
import java.util.List;

public class Queen extends Piece {

    public Queen(PieceColor color, Square initSq, String img_file) {
        super(color, initSq, img_file);
    }

    @Override
    protected MovementStrategy GetMovementStrategy() {
        return new StandardQueenMovement(this);
    }

}
