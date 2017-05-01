package gamecontrol;

import view.GameView;

import java.lang.*;
import java.util.*;


public class ComputerPlayer {

    private boolean cutOffOccurred;
    private boolean maxDepthReached;
    private int totalGenerateNodes;
    private int pruneMax;
    private int pruneMin;

    private int gameDifficulty;

    private int xNext;
    private int yNext;

    private BoardStatus boardInAlgo;
    private treeNode rootNode;

    ArrayList<treeNode> searchTree = new ArrayList<>();

    public int getNextStep(BoardStatus boardNow){

        rootNode = new treeNode();

        boardInAlgo = new BoardStatus();
        boardInAlgo.copyValueFrom(boardNow);

        rootNode.setRootNode(0, boardInAlgo);
        searchTree.add(rootNode);

        System.out.println("Please wait me!");

        int resultValue = ABCPruneSearch(rootNode); //get ab cutoff prune result value

        //System.out.println("RRRRRRRRREEEEEEZZUCLT VALUE: "+resultValue);

        System.out.println("Finished!");



        //
        //search the root node children with resultValue
        //


        for (treeNode node: rootNode.gettChild()){
            int v = node.getValue();
            if (v == resultValue) { // find the one with v = value
                this.setxNext(node.getStepX());
                this.setyNext(node.getStepY());
                break;
            }
        }


        this.setTotalGenerateNodes(searchTree.size());

        boardNow.setBoardOne(this.getxNext(), this.getyNext(), 1); //set one!



        /*
        for (treeNode test: searchTree) {
            System.out.println("========>next node: DEPTH: "+test.getDepth()+" !!!value: "+test.getValue()+"---step: [[["+test.getStepX()+", "+test.getStepY()+"]");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print("["+i + ", " + j + "]= " + test.getBoard().getBoardOne(i, j)+"; ");
                }
            }
            System.out.println("");
        }
        */


        searchTree.clear(); //clear tree

        //System.out.println("!!!!!"+this.getxNext()+this.getyNext());



        return (4*this.getxNext() + this.getyNext()); //return the positon in one value

    }





    public int ABCPruneSearch(treeNode node){
        int minUtility = -1000;
        int maxUtility = 1000;
        int depth = 0;
        int value;


        value = maxValue(node, depth, minUtility, maxUtility);


        return value;

    }

    public int maxValue(treeNode node, int depth, int a, int b){ //MAX-VALUE function: For X (computer)

        BoardStatus boardThisLevel = node.getBoard();

        int utility = boardThisLevel.isTerminal();
        if (utility != 0) { //come to an end!
            //System.out.println(depth+"come to end level in MAX. utiti: "+ utility);
            this.setMaxDepthReached(true);
            node.setValue(utility);
            return utility;
        }
        if (depth == gameDifficulty) { //cutoff test!
            this.setCutOffOccurred(true);
            boardThisLevel.computeEval();
            int eval = boardThisLevel.getEval();
            node.setValue(eval);
            return eval;
        }


        int value = -1111;
        for (int i=0; i<=3; i++){
            for (int j=0; j<=3; j++){
                if (boardThisLevel.getBoardOne(i, j) == 0){

                    boardThisLevel.setBoardOne(i, j, 1);

                    BoardStatus boardNextLevel = new BoardStatus();
                    boardNextLevel.copyValueFrom(boardThisLevel);

                    treeNode nodeNextLevel = new treeNode();
                    nodeNextLevel.setTreeNode(depth+1, boardNextLevel, i, j, node);
                    node.addChild(nodeNextLevel);
                    searchTree.add(nodeNextLevel);

                    value = Math.max(value, minValue(nodeNextLevel, depth+1, a, b));
                    boardThisLevel.unSetBoardOne(i, j);

                    if (value>=b) {//prune here
                        node.setValue(value); ///////////ATTENTION!!!!!!NODE OR NODENEXTLEVEL?????

                        int number = this.getPruneMax();
                        number= number+1;
                        this.setPruneMax(number);

                        return value;
                    }
                    a = Math.max(a, value);

                }
            }
        }
        node.setValue(value);
        return value;
    }

    public int minValue(treeNode node, int depth, int a, int b){ //MIN-VALUE function: For O (user)
        BoardStatus boardThisLevel = node.getBoard();

        int utility = boardThisLevel.isTerminal();
        if (utility != 0) { //come to an end!
            //System.out.println(depth+"come to end level in MIN utiti: "+ utility);
            this.setMaxDepthReached(true);
            node.setValue(utility);
            return utility;
        }

        if (depth == gameDifficulty) { //cutoff test! O
            this.setCutOffOccurred(true);
            boardThisLevel.computeEval();
            int eval = boardThisLevel.getEval();
            node.setValue(eval);
            return eval;
        }


        int value = 1111;
        for (int i=0; i<=3; i++){
            for (int j=0; j<=3; j++){
                if (boardThisLevel.getBoardOne(i, j) == 0){
                    boardThisLevel.setBoardOne(i, j, 10);

                    BoardStatus boardNextLevel = new BoardStatus();
                    boardNextLevel.copyValueFrom(boardThisLevel);

                    treeNode nodeNextLevel = new treeNode();
                    nodeNextLevel.setTreeNode(depth+1, boardNextLevel, i, j, node);
                    node.addChild(nodeNextLevel);
                    searchTree.add(nodeNextLevel);

                    value = Math.min(value, maxValue(nodeNextLevel, depth+1, a, b));
                    boardThisLevel.unSetBoardOne(i, j);

                    if (value<=a) { //prune here
                        node.setValue(value); ///////////ATTENTION!!!!!!NODE OR NODENEXTLEVEL?????

                        int number = this.getPruneMin();
                        number= number+1;
                        this.setPruneMin(number);

                        return value;
                    }
                    b = Math.min(b, value);

                }
            }
        }
        node.setValue(value);
        return value;
    }



    /*
     * Method for computer play first: first step. It will set X in (1, 1)
     * @param: BoardStatus board: boardNow in Class GameView
     */
    public void firstStep(BoardStatus board) {
        board.setBoardOne(1, 1, 1);

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

    public void setxNext(int i) {this.xNext = i;}
    public int getxNext() {return xNext;}

    public void setyNext(int i) {this.yNext = i;}
    public int getyNext() {return yNext;}
}
