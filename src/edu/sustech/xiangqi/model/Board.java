package edu.sustech.xiangqi.model;

// 保存棋盘数据，并统一检查和执行移动

public class Board {
    // 定义棋盘大小
    public static final int ROWS = 10;
    public static final int COLS = 9;

    // 存储棋子位置
    private final Piece[][] pieces = new Piece[ROWS][COLS];

    public Board() {
        initializePieces();
    }

    private void initializePieces() {
        pieces[0][0] = new CarPieceBlack();
        pieces[0][1] = new HorsePieceBlack();
        pieces[0][2] = new ElephantPieceBlack();
        pieces[0][3] = new AdvisorPieceBlack();
        pieces[0][4] = new GeneralPieceBlack();
        pieces[0][5] = new AdvisorPieceBlack();
        pieces[0][6] = new ElephantPieceBlack();
        pieces[0][7] = new HorsePieceBlack();
        pieces[0][8] = new CarPieceBlack();
        for(int i=0; i<=8; i+=2) pieces[3][i] = new SoldierPieceBlack();
        pieces[7][1] = new CannonPiece();
        pieces[7][7] = new CannonPiece();
        // 以上是黑棋导入
        // 以下是红棋导入
        pieces[2][1] = new CannonPieceBlack();
        pieces[2][7] = new CannonPieceBlack();
        for(int i=0; i<=8; i+=2) pieces[6][i] = new SoldierPiece();
        pieces[9][0] = new CarPiece();
        pieces[9][1] = new HorsePiece();
        pieces[9][2] = new ElephantPiece();
        pieces[9][3] = new AdvisorPiece();
        pieces[9][4] = new GeneralPiece();
        pieces[9][5] = new AdvisorPiece();
        pieces[9][6] = new ElephantPiece();
        pieces[9][7] = new HorsePiece();
        pieces[9][8] = new CarPiece();
    }

    public boolean isInside(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    public Piece getPieceAt(int row, int col) {
        if (!isInside(row, col)) return null;
        return pieces[row][col];
    }

    public boolean tryMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (!isInside(fromRow, fromCol) || !isInside(toRow, toCol)) return false;

        if (fromRow == toRow && fromCol == toCol) return false;

        Piece piece = getPieceAt(fromRow, fromCol);
        if (piece == null) return false;

        // TODO: 加入回合检查，只允许当前一方移动自己的棋子

        // TODO: 区分己方占用与敌方棋子，并实现吃子 ok
        if (!piece.canMove(this, fromRow, fromCol, toRow, toCol)) return false; // 特定棋子的可走判定

        if (getPieceAt(toRow, toCol) != null) { // 吃子判定
            if (piece.isRed() == getPieceAt(toRow,toCol).isRed()) return false; // 同阵营棋子不吃
            else { // 非同阵营棋子可吃
                pieces[fromRow][fromCol] = null;
                pieces[toRow][toCol] = piece;
                return true;
            }
        }

        // TODO: 检查走完后己方将帅是否安全
        pieces[fromRow][fromCol] = null;
        pieces[toRow][toCol] = piece;

        // TODO: 仅在成功移动后切换回合，并判断将军、胜负等状态
        return true;
    }
//    public boolean checkmate() {
//        for()
//    }
}
