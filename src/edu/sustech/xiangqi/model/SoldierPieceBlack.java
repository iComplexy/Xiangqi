package edu.sustech.xiangqi.model;
// 黑兵
public class SoldierPieceBlack extends Piece{
    public SoldierPieceBlack() { super("卒",false); }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        if(toCol < 0 || toCol > 8) return false;
        if(toRow < 0 || toRow > 9) return false;
        if(fromRow < 5) return fromCol == toCol && fromRow - toRow == -1; // 没过河只能冲兵 不能横移
        else // 过河可以冲兵或者横移
            return fromRow - toRow == -1 && fromCol == toCol || fromRow == toRow && Math.abs(toCol - fromCol) == 1;
    }
}
