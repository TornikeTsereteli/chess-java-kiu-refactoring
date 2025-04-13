package chess.model;

import chess.model.enums.PieceColor;
import chess.movement.MovementStrategy;
import chess.movement.StandardRookMovement;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {

    public Rook(PieceColor color, Square initSq, String img_file) {
        super(color, initSq, img_file);
    }

    @Override
    protected MovementStrategy GetMovementStrategy() {
        return new StandardRookMovement(this);
    }


}
