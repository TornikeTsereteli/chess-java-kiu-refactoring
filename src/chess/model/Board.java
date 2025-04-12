package chess.model;

import chess.model.enums.PieceColor;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private final Square[][] board;
    private final LinkedList<Piece> Bpieces = new LinkedList<>();
    private final LinkedList<Piece> Wpieces = new LinkedList<>();
    private final CheckmateDetector cmd;

    private boolean whiteTurn = true;
    private Piece currPiece;


        private static final String RESOURCES_WBISHOP_PNG = "/wbishop.png";
    private static final String RESOURCES_BBISHOP_PNG = "/bbishop.png";
    private static final String RESOURCES_WKNIGHT_PNG = "/wknight.png";
    private static final String RESOURCES_BKNIGHT_PNG = "/bknight.png";
    private static final String RESOURCES_WROOK_PNG = "/wrook.png";
    private static final String RESOURCES_BROOK_PNG = "/brook.png";
    private static final String RESOURCES_WKING_PNG = "/wking.png";
    private static final String RESOURCES_BKING_PNG = "/bking.png";
    private static final String RESOURCES_BQUEEN_PNG = "/bqueen.png";
    private static final String RESOURCES_WQUEEN_PNG = "/wqueen.png";
    private static final String RESOURCES_WPAWN_PNG = "/wpawn.png";
    private static final String RESOURCES_BPAWN_PNG = "/bpawn.png";

    public Board() {
        board = new Square[8][8];
        initializeBoardSquares();
        initializePieces();
        cmd = new CheckmateDetector(this, Wpieces, Bpieces, getWhiteKing(), getBlackKing());
    }

    private void initializeBoardSquares() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                PieceColor color = ((x + y) % 2 == 0) ? PieceColor.WHITE : PieceColor.BLACK;
                board[y][x] = new Square(this, color, x, y);
            }
        }
    }

    private void initializePieces() {
        // Add pawns
        for (int x = 0; x < 8; x++) {
            board[1][x].put(new Pawn(PieceColor.BLACK, board[1][x], "/bpawn.png"));
            board[6][x].put(new Pawn(PieceColor.WHITE, board[6][x], "/wpawn.png"));
        }

        // Add kings and queens
        board[0][4].put(new King(PieceColor.BLACK, board[0][4], "/bking.png"));
        board[7][4].put(new King(PieceColor.WHITE, board[7][4], "/wking.png"));
        board[0][3].put(new Queen(PieceColor.BLACK, board[0][3], "/bqueen.png"));
        board[7][3].put(new Queen(PieceColor.WHITE, board[7][3], "/wqueen.png"));

        // Add other pieces (rooks, knights, bishops)
        board[0][0].put(new Rook(PieceColor.BLACK, board[0][0], RESOURCES_BROOK_PNG));
        board[0][7].put(new Rook(PieceColor.BLACK, board[0][7], RESOURCES_BROOK_PNG));
        board[7][0].put(new Rook(PieceColor.WHITE, board[7][0], RESOURCES_WROOK_PNG));
        board[7][7].put(new Rook(PieceColor.WHITE, board[7][7], RESOURCES_WROOK_PNG));

        board[0][1].put(new Knight(PieceColor.BLACK, board[0][1], RESOURCES_BKNIGHT_PNG));
        board[0][6].put(new Knight(PieceColor.BLACK, board[0][6], RESOURCES_BKNIGHT_PNG));
        board[7][1].put(new Knight(PieceColor.WHITE, board[7][1], RESOURCES_WKNIGHT_PNG));
        board[7][6].put(new Knight(PieceColor.WHITE, board[7][6], RESOURCES_WKNIGHT_PNG));

        board[0][2].put(new Bishop(PieceColor.BLACK, board[0][2], RESOURCES_BBISHOP_PNG));
        board[0][5].put(new Bishop(PieceColor.BLACK, board[0][5], RESOURCES_BBISHOP_PNG));
        board[7][2].put(new Bishop(PieceColor.WHITE, board[7][2], RESOURCES_WBISHOP_PNG));
        board[7][5].put(new Bishop(PieceColor.WHITE, board[7][5], RESOURCES_WBISHOP_PNG));

        // Add to Bpieces and Wpieces
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 8; x++) {
                Bpieces.add(board[y][x].getOccupyingPiece());
                Wpieces.add(board[7 - y][x].getOccupyingPiece());
            }
        }
    }

    public Square[][] getSquareArray() {
        return board;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public void toggleTurn() {
        whiteTurn = !whiteTurn;
    }

    public Piece getCurrPiece() {
        return currPiece;
    }

    public void setCurrPiece(Piece currPiece) {
        this.currPiece = currPiece;
    }

    public CheckmateDetector getCheckmateDetector() {
        return cmd;
    }
        public boolean getTurn() {
        return whiteTurn;
    }

    public King getWhiteKing() {
        return (King) board[7][4].getOccupyingPiece();
    }

    public King getBlackKing() {
        return (King) board[0][4].getOccupyingPiece();
    }

    public LinkedList<Piece> getWhitePieces() {
        return Wpieces;
    }

    public LinkedList<Piece> getBlackPieces() {
        return Bpieces;
    }
}
