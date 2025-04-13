package chess.model;

import chess.model.enums.PieceColor;
import chess.movement.MovementStrategy;
import chess.movement.StandardPawnMovement;

import java.util.List;
import java.util.LinkedList;

public class Pawn extends Piece {


    public Pawn(PieceColor color, Square initSq, String img_file) {
        super(color, initSq, img_file);
    }

    @Override
    protected MovementStrategy GetMovementStrategy() {
        return new StandardPawnMovement(this,false);
    }

    @Override
    public boolean move(Square fin) {
        setMovementStrategy(new StandardPawnMovement(this,true));
        return super.move(fin);
    }
}
