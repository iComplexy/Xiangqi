package edu.sustech.xiangqi.model;

// 红象：每次斜走日

public class ElephantPiece extends Piece {
    public ElephantPiece() {
        super("相", true);
    }
    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // 行和列必须都变化2格，不能直走、原地停留或跨越多格
        if (Math.abs(toRow - fromRow) != 2 || Math.abs(toCol - fromCol) != 2)
            return false;
        if (toCol < 0 || toCol > 8) return false; // 列判断
        return toRow >= 5 && toRow <= 9; // 行判断
    }
}
