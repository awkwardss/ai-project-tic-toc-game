package gamecontrol;

/**
 * The node constructor of the game tree
 * Created by awkward-ss on 17/4/24.
 */
public class treeNode {
    private int utility;
    private int eval;
    private int value;
    private int depth;
    private BoardStatus board;
    private int stepX;
    private int stepY;


    public void treeNode(int u, int e, int v, int d, BoardStatus b, int x, int y){
        this.utility = u;
        this.eval = e;
        this.value = v;
        this.depth = d;
        this.board = b;
        this.stepX = x;
        this.stepY = y;
    }

    public void treeNode(int v, int d, int x, int y){
        this.value = v;
        this.depth = d;
        this.stepX = x;
        this.stepY = y;
    }

    public void setUtility(int i) {this.utility = i;}
    public void setEval(int i) {this.eval = i;}
    public void setValue(int i) {this.value = i;}
    public void setDepth(int i) {this.depth = i;}
    public void setBoard(BoardStatus b) {this.board = b;}
    public void setStepX(int i) {this.stepX = i;}
    public void setStepY(int i) {this.stepY = i;}

    public int getValue() {return this.value;}
    public int getDepth() {return this.depth;}
    public int getStepX() {return this.stepX;}
    public int getStepY() {return this.stepY;}
}
