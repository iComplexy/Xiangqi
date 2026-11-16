package edu.sustech.xiangqi.model;

// 黑象：每次斜走日

public class ElephantPieceBlack extends Piece {
    public ElephantPieceBlack() {
        super("象", false);
    }
    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // 行和列必须都变化2格，不能直走、原地停留或跨越多格
        if (Math.abs(toRow - fromRow) != 2 || Math.abs(toCol - fromCol) != 2)
            return false;
        if (toCol < 0 || toCol > 8) return false; // 列判断
        if (!(toRow >= 0 && toRow <= 4)) return false; // 行判断
        int midrow = (fromRow + toRow) / 2;
        int midcol = (fromCol + toCol) / 2;
        if(board.getPieceAt(midrow,midcol) != null) return false;
        return true;
    }
}
