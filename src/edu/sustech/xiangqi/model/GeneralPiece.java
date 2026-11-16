package edu.sustech.xiangqi.model;

// 红帅

public class GeneralPiece extends Piece {
    public GeneralPiece() {
        super("帅", true);
    }
    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // 九宫格行列的判定
        if(toCol < 3 || toCol > 5) return false;
        if(toRow < 7 || toRow > 9) return false;
        // 一次只能移动一格
        return Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 0 || Math.abs(toCol - fromCol) == 1 && Math.abs(toRow - fromRow) == 0;
    }
}
