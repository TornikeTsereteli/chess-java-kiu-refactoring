package chess.model;

import chess.common.moveExecutor.BasicMoveExecutor;
import chess.common.moveExecutor.MoveExecutorStrategy;
import chess.model.enums.PieceColor;
import chess.common.movement.MovementStrategy;
import chess.common.movement.StandardPawnMovement;

public class Pawn extends Piece {


    public Pawn(PieceColor color, Square initSq, String img_file) {
        super(color, initSq, img_file);
    }

    @Override
    protected MovementStrategy getMovementStrategy() {
        return new StandardPawnMovement(this,false);
    }

    @Override
    protected MoveExecutorStrategy getMoveExecutorStrategy() {
        return new BasicMoveExecutor(this);
    }

//    @Override
//    public boolean attacksSquare(Square target, Board board) {
//        int dx = target.getPosition().getX() - this.getPosition().getPosition().getX();
//        int dy = target.getPosition().getY() - this.getPosition().getPosition().getY();
//
//        int direction = (this.getColor() == PieceColor.WHITE) ? 1 : -1;
//        return Math.abs(dx) == 1 && dy == direction;
//    }

    @Override
    public boolean move(Square fin,Board board) {
        setMovementStrategy(new StandardPawnMovement(this,true));
        return super.move(fin,board);
    }
}
