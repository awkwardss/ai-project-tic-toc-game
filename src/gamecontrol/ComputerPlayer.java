package gamecontrol;

import view.GameView;

import java.lang.*;

public class ComputerPlayer {

    private boolean cutOffOccurred;
    private boolean maxDepthReached;
    private int totalGenerateNodes;
    private int pruneMax;
    private int pruneMin;

    private int gameDifficulty;

    private BoardStatus boardNow;




    public int[][] ABCPruneSearch(BoardStatus board){
        int minUtility = -1000;
        int maxUtility = 1000;
        int depth = 0;
        int value;
        int[][] bestMove = new int [1][1];

        value = maxValue(board, 0, -1000, 1000);


        return bestMove;
    }

    public int maxValue(BoardStatus board, int depth, int a, int b){ //MAX-VALUE function: For X (computer)
        int utility = board.isTerminal();
        if (utility != 0) { //come to an end!
            return utility;
        }
        if (depth == gameDifficulty) { //cutoff test!
            board.computeEval();
            int eval = board.getEval();
            return eval;
        }


        int value = -1111;
        for (int i=0; i<=3; i++){
            for (int j=0; j<=3; j++){
                if (board.getBoardOne(i, j) == 0){
                    board.setBoardOne(i, j, 1);
                    value = Math.max(value, minValue(board, depth+1, a, b));
                    if (value>=b) {return value;}
                    a = Math.max(a, value);

                }
            }
        }
        return value;
    }

    public int minValue(BoardStatus board, int depth, int a, int b){ //MIN-VALUE function: For O (user)
        int utility = board.isTerminal();
        if (utility != 0) { //come to an end!
            return utility;
        }
        if (depth == gameDifficulty) { //cutoff test!
            board.computeEval();
            int eval = board.getEval();
            return eval;
        }

        int value = 1111;
        for (int i=0; i<=3; i++){
            for (int j=0; j<=3; j++){
                if (board.getBoardOne(i, j) == 0){
                    board.setBoardOne(i, j, 10);
                    value = Math.min(value, maxValue(board, depth+1, a, b));
                    if (value<=a) {return value;}
                    b = Math.min(b, value);

                }
            }
        }
        return value;
    }




    //public int max (int i, int j) { if (i >= j) return i; else return j;}

    public void setCutOffOccurred(boolean cutOffOccurred1) {this.cutOffOccurred = cutOffOccurred1;}
    public boolean getCutOffOccurred() {return this.cutOffOccurred;}

    public void setMaxDepthReached(boolean maxDepthReached1) {this.maxDepthReached = maxDepthReached1;}
    public boolean getMaxDepthReached() {return this.maxDepthReached;}

    public void setTotalGenerateNodes(int i) {this.totalGenerateNodes = i;}
    public int getTotalGenerateNodes() {return this.totalGenerateNodes;}

    public void setPruneMax(int p) {this.pruneMax = p;}
    public int getPruneMax() {return pruneMax;}

    public void setPruneMin(int p) {this.pruneMin = p;}
    public int getPruneMin() {return pruneMin;}

    public void setGameDifficulty(int i) {this.gameDifficulty = i;}
    public int getGameDifficulty() {return gameDifficulty;}
}
