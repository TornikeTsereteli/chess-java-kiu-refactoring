//package chess.model;
//
//import chess.model.enums.PieceColor;
//import chess.ui.GameWindow;
//import chess.ui.SquareRendering;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.Point;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.util.LinkedList;
//import java.util.List;
//
//import javax.swing.*;
//
//@SuppressWarnings("serial")
//public class Board extends JPanel implements MouseListener,MouseMotionListener {
//    // Resource location constants for piece images
//    private static final String RESOURCES_WBISHOP_PNG = "/wbishop.png";
//    private static final String RESOURCES_BBISHOP_PNG = "/bbishop.png";
//    private static final String RESOURCES_WKNIGHT_PNG = "/wknight.png";
//    private static final String RESOURCES_BKNIGHT_PNG = "/bknight.png";
//    private static final String RESOURCES_WROOK_PNG = "/wrook.png";
//    private static final String RESOURCES_BROOK_PNG = "/brook.png";
//    private static final String RESOURCES_WKING_PNG = "/wking.png";
//    private static final String RESOURCES_BKING_PNG = "/bking.png";
//    private static final String RESOURCES_BQUEEN_PNG = "/bqueen.png";
//    private static final String RESOURCES_WQUEEN_PNG = "/wqueen.png";
//    private static final String RESOURCES_WPAWN_PNG = "/wpawn.png";
//    private static final String RESOURCES_BPAWN_PNG = "/bpawn.png";
//
//    // Logical and graphical representations of board
//    private final Square[][] board;
//    private final GameWindow g;
//
//    // List of pieces and whether they are movable
//    public final LinkedList<Piece> Bpieces;
//    public final LinkedList<Piece> Wpieces;
//
//    //    @Getter
////    @Setter
//    public List<Square> movable;
//
//
//    private boolean whiteTurn;
//
//
//    //    @Getter
////    @Setter
//    private Piece currPiece;
//
//
//    private int currX;
//    private int currY;
//
//
//    //    @Getter
//    private CheckmateDetector cmd;
//
//    public Board(GameWindow g) {
//        this.g = g;
//        board = new Square[8][8];
//        Bpieces = new LinkedList<Piece>();
//        Wpieces = new LinkedList<Piece>();
//        setLayout(new GridLayout(8, 8, 0, 0));
//
//        this.addMouseListener(this);
//        this.addMouseMotionListener(this);
//
//        initializeBoardSquares();
//
//        initializePieces();
//
//        this.setPreferredSize(new Dimension(400, 400));
//        this.setMaximumSize(new Dimension(400, 400));
//        this.setMinimumSize(this.getPreferredSize());
//        this.setSize(new Dimension(400, 400));
//
//        whiteTurn = true;
//
//    }
//
//
//    public void setMovable(List<Square> movable) {
//        this.movable = movable;
//    }
//
//
////    public Piece getCurrPiece() {
////        return currPiece;
////    }
//
//    public List<Square> getMovable() {
//        return movable;
//    }
//
//    public boolean isWhiteTurn() {
//        return whiteTurn;
//    }
//
//    public CheckmateDetector getCmd() {
//        return cmd;
//    }
//
//
//    private void initializeBoardSquares() {
//        for (int x = 0; x < 8; x++) {
//            for (int y = 0; y < 8; y++) {
//                int xMod = x % 2;
//                int yMod = y % 2;
//
//                if ((xMod == 0 && yMod == 0) || (xMod == 1 && yMod == 1)) {
//                    board[x][y] = new Square(this, PieceColor.WHITE, y, x);
////                    this.add(board[x][y]);
//                    this.add(new SquareRendering(board[x][y]));
//                } else {
//                    board[x][y] = new Square(this, PieceColor.BLACK, y, x);
////                    this.add(new board[x][y]);
//                    this.add(new SquareRendering(board[x][y]));
//                }
//            }
//        }
//    }
//
//    private void initializePieces() {
//
//        for (int x = 0; x < 8; x++) {
//            board[1][x].put(new Pawn(PieceColor.BLACK, board[1][x], RESOURCES_BPAWN_PNG));
//            board[6][x].put(new Pawn(PieceColor.WHITE, board[6][x], RESOURCES_WPAWN_PNG));
//        }
//
//        board[7][3].put(new Queen(PieceColor.WHITE, board[7][3], RESOURCES_WQUEEN_PNG));
//        board[0][3].put(new Queen(PieceColor.BLACK, board[0][3], RESOURCES_BQUEEN_PNG));
//
//        King bk = new King(PieceColor.BLACK, board[0][4], RESOURCES_BKING_PNG);
//        King wk = new King(PieceColor.WHITE, board[7][4], RESOURCES_WKING_PNG);
//        board[0][4].put(bk);
//        board[7][4].put(wk);
//
//        board[0][0].put(new Rook(PieceColor.BLACK, board[0][0], RESOURCES_BROOK_PNG));
//        board[0][7].put(new Rook(PieceColor.BLACK, board[0][7], RESOURCES_BROOK_PNG));
//        board[7][0].put(new Rook(PieceColor.WHITE, board[7][0], RESOURCES_WROOK_PNG));
//        board[7][7].put(new Rook(PieceColor.WHITE, board[7][7], RESOURCES_WROOK_PNG));
//
//        board[0][1].put(new Knight(PieceColor.BLACK, board[0][1], RESOURCES_BKNIGHT_PNG));
//        board[0][6].put(new Knight(PieceColor.BLACK, board[0][6], RESOURCES_BKNIGHT_PNG));
//        board[7][1].put(new Knight(PieceColor.WHITE, board[7][1], RESOURCES_WKNIGHT_PNG));
//        board[7][6].put(new Knight(PieceColor.WHITE, board[7][6], RESOURCES_WKNIGHT_PNG));
//
//        board[0][2].put(new Bishop(PieceColor.BLACK, board[0][2], RESOURCES_BBISHOP_PNG));
//        board[0][5].put(new Bishop(PieceColor.BLACK, board[0][5], RESOURCES_BBISHOP_PNG));
//        board[7][2].put(new Bishop(PieceColor.WHITE, board[7][2], RESOURCES_WBISHOP_PNG));
//        board[7][5].put(new Bishop(PieceColor.WHITE, board[7][5], RESOURCES_WBISHOP_PNG));
//
//
//        for (int y = 0; y < 2; y++) {
//            for (int x = 0; x < 8; x++) {
//                Bpieces.add(board[y][x].getOccupyingPiece());
//                Wpieces.add(board[7 - y][x].getOccupyingPiece());
//            }
//        }
//
//        cmd = new CheckmateDetector(this, Wpieces, Bpieces, wk, bk);
//    }
//
//    public Square[][] getSquareArray() {
//        return this.board;
//    }
//
//    public boolean getTurn() {
//        return whiteTurn;
//    }
//
//    public void setCurrPiece(Piece p) {
//        this.currPiece = p;
//    }
//
//    public Piece getCurrPiece() {
//        return this.currPiece;
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        // Draw the board squares and their pieces
//        for (int x = 0; x < 8; x++) {
//            for (int y = 0; y < 8; y++) {
//                Square sq = board[y][x];
//                SquareRendering squareRendering = new SquareRendering(sq);
//                squareRendering.paintComponent(g);
//            }
//        }
//
//        if (currPiece != null) {
//            if ((currPiece.getColor() == PieceColor.WHITE && whiteTurn)
//                    || (currPiece.getColor() == PieceColor.BLACK && !whiteTurn)) {
//                final Image pieceImage = currPiece.getImage();
//                if (pieceImage != null) {
//                    g.drawImage(pieceImage, currX, currY,null);
//                    repaint();
//                }
//            }
//        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        currX = e.getX();
//        currY = e.getY();
//
////        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));
//        SquareRendering squareRendering = (SquareRendering) this.getComponentAt(new Point(e.getX(), e.getY()));
//        Square sq = squareRendering.getSquare();
//        if (sq.isOccupied()) {
//            currPiece = sq.getOccupyingPiece();
//            if (currPiece.getColor() == PieceColor.BLACK && whiteTurn)
//                return;
//            if (currPiece.getColor() == PieceColor.WHITE && !whiteTurn)
//                return;
//            sq.setDisplay(false);
//        }
//        repaint();
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
////        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));
//        SquareRendering squareRendering = (SquareRendering) this.getComponentAt(new Point(e.getX(), e.getY()));
//        Square sq = squareRendering.getSquare();
//        if (currPiece != null) {
//            if (currPiece.getColor() == PieceColor.BLACK && whiteTurn)
//                return;
//            if (currPiece.getColor() == PieceColor.WHITE && !whiteTurn)
//                return;
//
//            List<Square> legalMoves = currPiece.getLegalMoves(this);
//            movable = cmd.getAllowableSquares(whiteTurn);
//
//            if (legalMoves.contains(sq) && movable.contains(sq)
//                    && cmd.testMove(currPiece, sq)) {
//                sq.setDisplay(true);
//                currPiece.move(sq);
//                cmd.update();
//
//                if (cmd.blackCheckMated()) {
//                    currPiece = null;
//                    repaint();
//                    this.removeMouseListener(this);
//                    this.removeMouseMotionListener(this);
//                    g.checkmateOccurred(0);
//                } else if (cmd.whiteCheckMated()) {
//                    currPiece = null;
//                    repaint();
//                    this.removeMouseListener(this);
//                    this.removeMouseMotionListener(this);
//                    g.checkmateOccurred(1);
//                } else {
//                    currPiece = null;
//                    whiteTurn = !whiteTurn;
//                    movable = cmd.getAllowableSquares(whiteTurn);
//                }
//
//            } else {
//                currPiece.getPosition().setDisplay(true);
//                currPiece = null;
//            }
//        }
//
//        repaint();
//    }
//
//    @Override
//    public void mouseDragged(MouseEvent e) {
//        currX = e.getX() - 24;
//        currY = e.getY() - 24;
//
//        repaint();
//    }
//
//    // Irrelevant methods, do nothing for these mouse behaviors
//    @Override
//    public void mouseMoved(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//    }
//
//}