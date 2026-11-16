package edu.sustech.xiangqi.model;

// 红炮

public class CannonPiece extends Piece {
    public CannonPiece() {
        super("炮", true);
    }
    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        if (toCol < 0 || toCol > 8) return false; // 列边界判断
        if (toRow < 0 || toRow > 9) return false; // 行边界判断
        if (!(Math.abs(toRow - fromRow) != 0 && Math.abs(toCol - fromCol) == 0 || Math.abs(toCol - fromCol) != 0 && Math.abs(toRow - fromRow) == 0))
            return false; // 只能沿着单行或者单列走
        boolean stu = false; // stu用于存储是否存在炮台 true即有炮台
        Piece p0 = board.getPieceAt(fromRow,fromCol); // 炮的初始位置
        Piece p = board.getPieceAt(toRow,toCol); // 炮的落点
        if (fromCol == toCol) { // 沿着一列打
            if(fromRow > toRow) {
                for (int i=fromRow-1; i>toRow; i--) // 从炮的初始位置向落点遍历
                    if (board.getPieceAt(i,fromCol) != null) { // 有炮台
                        stu = true; // 标记成有炮台
                        for (int j=i-1; j>toRow; j--) { // 遍历 除了始末位置和炮台以外 还有没有障碍
                            Piece pp = board.getPieceAt(j,fromCol); /* 高射炮是因为这个地方横纵写反了 */
                            if (pp != null) return false; // 有其他障碍 即高射炮情况 打不过去
                        }
                        if(p.isRed() == p0.isRed()) return false; // 始末位置阵营相同就打不过去
                    }
            }
            else { // 还是从炮的初始位置向落点遍历 同上
                for (int i=fromRow+1; i<toRow; i++)
                    if (board.getPieceAt(i,fromCol) != null) {
                        stu = true;
                        for (int j=i+1; j<toRow; j++) {
                            Piece pp = board.getPieceAt(j,fromCol);
                            if (pp != null) return false;
                        }
                        if(p.isRed() == p0.isRed()) return false;
                    }
            }
        }
        else { // 沿着一行打 同上
            if(fromCol > toCol) {
                for (int i=fromCol-1; i>toCol; i--)
                    if (board.getPieceAt(fromRow,i) != null) {
                        stu = true;
                        for (int j=i-1; j>toCol; j--) {
                            Piece pp = board.getPieceAt(fromRow,j);
                            if (pp != null) return false;
                        }
                        if(p.isRed() == p0.isRed()) return false;
                    }
            }
            else {
                for (int i=fromCol+1; i<toCol; i++)
                    if (board.getPieceAt(fromRow,i) != null) {
                        stu = true;
                        for (int j=i+1; j<toCol; j++) {
                            Piece pp = board.getPieceAt(fromRow,j);
                            if (pp != null) return false;
                        }
                        if(p.isRed() == p0.isRed()) return false;
                    }
            }
        }
        if(!stu && board.getPieceAt(toRow,toCol) != null) return false; // 没有炮台 但是落点有对方的棋子 打不过去
        if(stu) { // 有炮台
            if(board.getPieceAt(toRow,toCol) == null) return false; // 落点是空的 打不过去
            else if(p.isRed() == p0.isRed()) return false; // 落点不是空的 但是落点是友方棋子
        }
        return true;
    }
}
