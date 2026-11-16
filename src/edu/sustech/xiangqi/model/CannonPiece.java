package edu.sustech.xiangqi.model;

// 红炮

public class CannonPiece extends Piece {
    public CannonPiece() {
        super("炮", true);
    }
    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        if (toCol < 0 || toCol > 8) return false;
        if (toRow < 0 || toRow > 9) return false;
        return Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 0 || Math.abs(toCol - fromCol) == 1 && Math.abs(toRow - fromRow) == 0;
    }
}
