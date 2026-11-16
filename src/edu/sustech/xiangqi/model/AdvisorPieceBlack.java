package edu.sustech.xiangqi.model;

// 黑仕：每次斜走一格，不能离开黑方九宫

public class AdvisorPieceBlack extends Piece {
    public AdvisorPieceBlack() {
        super("士", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // 行和列必须都变化一格，不能直走、原地停留或跨越多格
        if (Math.abs(toRow - fromRow) != 1 || Math.abs(toCol - fromCol) != 1) return false;
        if (toCol < 3 || toCol > 5) return false; // 列判断
        return toRow >= 0 && toRow <= 2; // 行判断
    }
}
