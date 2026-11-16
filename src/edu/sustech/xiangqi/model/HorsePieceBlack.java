package edu.sustech.xiangqi.model;
// 黑马
public class HorsePieceBlack extends Piece{
    public HorsePieceBlack() {
        super("馬", false);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // 行和列必须都变化1 2或者2 1格，不能直走、原地停留或跨越多格
        Board b = new Board();
        if (!(Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 1 || Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 2))
            return false;
        if (toCol < 0 || toCol > 8) return false; // 列判断
        if(!(toRow >= 0 && toRow <= 9)) return false; // 行判断

        if(Math.abs(fromCol - toCol) == 1) {
            int footrow = (fromRow + toRow) / 2;
            if(b.getPieceAt(footrow,fromCol) != null) return false;
        } // 马脚判定1
        if(Math.abs(fromRow - toRow) == 1) {
            int footcol = (fromCol + toCol) / 2;
            if(b.getPieceAt(fromRow,footcol) != null) return false;
        } // 马脚判定2
        return true;
    }
}
