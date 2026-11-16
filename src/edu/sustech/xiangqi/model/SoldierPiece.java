package edu.sustech.xiangqi.model;
// 红兵
public class SoldierPiece extends Piece{
    public SoldierPiece() { super("兵",true); }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        if(toCol < 0 || toCol > 8) return false; // 列判定
        if(toRow < 0 || toRow > 9) return false; // 行判定
        if(fromRow > 4) return fromCol == toCol && fromRow - toRow == 1; // 没过河只能冲兵 不能横移
        else // 过河可以冲兵或者横移
            return fromRow - toRow == 1 && fromCol == toCol || fromRow == toRow && Math.abs(toCol - fromCol) == 1;
    }
}
