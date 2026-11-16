package edu.sustech.xiangqi.model;
// 红车

public class CarPiece extends Piece{
    public CarPiece() { super("車",true); }
    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        Board b = new Board();
        if (toCol < 0 || toCol > 8) return false;
        if (toRow < 0 || toRow > 9) return false;
        if (!(Math.abs(toRow - fromRow) != 0 && Math.abs(toCol - fromCol) == 0 || Math.abs(toCol - fromCol) != 0 && Math.abs(toRow - fromRow) == 0))
            return false; // 必须沿着一行走或者沿着一列走
        if (fromRow == toRow) { // 如果沿着一行走 行坐标相同 该行的起始与终止位置间不能有别的棋子
            int maxcol = Math.max(fromCol,toCol);
            int mincol = Math.min(fromCol,toCol);
            for(int i=mincol+1; i<maxcol; i++) if(b.getPieceAt(fromRow,i) != null) return false;
        }
        if (fromCol == toCol) { // 列同理
            int maxrow = Math.max(fromRow,toRow);
            int minrow = Math.min(fromRow,toRow);
            for (int i=minrow+1; i<maxrow; i++) if(b.getPieceAt(i,fromCol) != null) return false;
        }
        return true;
    }
}
