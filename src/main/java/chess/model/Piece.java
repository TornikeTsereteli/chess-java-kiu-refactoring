package chess.model;

import chess.model.enums.PieceColor;
import chess.movement.MovementStrategy;
import chess.util.PieceImageLoader;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class Piece {
    private final PieceColor color;
    private Square currentSquare;
    private BufferedImage img;
    @Setter
    private MovementStrategy movementStrategy;

    public Piece(PieceColor color, Square initSq, String img_file) {
        this.color = color;
        this.currentSquare = initSq;

        this.img = PieceImageLoader.loadImage(img_file);
        this.movementStrategy = GetMovementStrategy();
    }

    public boolean move(Square fin) {
        Piece occup = fin.getOccupyingPiece();

        if (occup != null) {
            if (occup.getColor() == this.color) return false;
            else fin.capture(this);
        }

        currentSquare.removePiece();
        this.currentSquare = fin;
        currentSquare.put(this);
        return true;
    }

    protected abstract MovementStrategy GetMovementStrategy();



    public Square getPosition() {
        return currentSquare;
    }

    public void setPosition(Square sq) {
        this.currentSquare = sq;
    }

    public PieceColor getColor() {
        return color;
    }

    public Image getImage() {
        return img;
    }

    public List<Square> getLegalMoves(Board b) {
        return movementStrategy.getLegalMoves(b);
    }



}