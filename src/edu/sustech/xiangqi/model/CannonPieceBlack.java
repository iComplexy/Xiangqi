package edu.sustech.xiangqi.model;

// 黑炮

public class CannonPieceBlack extends Piece {
    public CannonPieceBlack() {
        super("炮", false);
    }
    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        if (toCol < 0 || toCol > 8) return false;
        if (toRow < 0 || toRow > 9) return false;
        if (!(Math.abs(toRow - fromRow) != 0 && Math.abs(toCol - fromCol) == 0 || Math.abs(toCol - fromCol) != 0 && Math.abs(toRow - fromRow) == 0))
            return false;
        boolean stu = false;
        Piece p0 = board.getPieceAt(fromRow,fromCol);
        Piece p = board.getPieceAt(toRow,toCol);
        if (fromCol == toCol) {
            if(fromRow > toRow) {
                for (int i=fromRow-1; i>toRow; i--)
                    if (board.getPieceAt(i,fromCol) != null) {
                        stu = true;
                        for (int j=i-1; j>toRow; j--) {
                            Piece pp = board.getPieceAt(j,fromCol);
                            if (pp != null) return false;
                        }
                        if(p.isRed() == p0.isRed()) return false;
                    }
            }
            else {
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
        else {
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
        if(!stu && board.getPieceAt(toRow,toCol) != null) return false;
        if(stu) {
            if(board.getPieceAt(toRow,toCol) == null) return false;
            else if(p.isRed() == p0.isRed()) return false;
        }
        return true;
    }
}
