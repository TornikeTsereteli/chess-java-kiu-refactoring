package chess.model;

import chess.model.enums.PieceColor;
import chess.movement.MovementStrategy;
import chess.movement.StandardKingMovement;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece {

    public King(PieceColor color, Square initSq, String img_file) {
        super(color, initSq, img_file);
    }

    @Override
    protected MovementStrategy GetMovementStrategy() {
        return new StandardKingMovement(this);
    }


}
