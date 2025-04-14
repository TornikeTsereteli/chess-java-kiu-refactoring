package chess.model;

import chess.common.moveExecutor.BasicMoveExecutor;
import chess.common.moveExecutor.MoveExecutorStrategy;
import chess.model.enums.PieceColor;
import chess.common.movement.MovementStrategy;
import chess.common.movement.StandardKnightMovement;

public class Knight extends Piece {

    public Knight(PieceColor color, Square initSq, String img_file) {
        super(color, initSq, img_file);
    }

    @Override
    protected MovementStrategy getMovementStrategy() {
        return new StandardKnightMovement(this);
    }

    @Override
    protected MoveExecutorStrategy getMoveExecutorStrategy() {
        return new BasicMoveExecutor(this);
    }

//    @Override
//    public boolean attacksSquare(Square target, Board board) {
//        int dx = Math.abs(this.getPosition().getPosition().getX() - target.getPosition().getX());
//        int dy = Math.abs(this.getPosition().getPosition().getY() - target.getPosition().getY());
//        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
//    }


}
