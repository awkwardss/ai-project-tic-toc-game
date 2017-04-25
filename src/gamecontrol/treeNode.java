package gamecontrol;

import java.util.ArrayList;

/**
 * The node constructor of the game tree
 * Created by awkward-ss on 17/4/24.
 */
public class treeNode {
    private int value;
    private int depth;
    private BoardStatus board;
    private int stepX;
    private int stepY;

    private treeNode tFather;
    private ArrayList<treeNode> tChild = new ArrayList<treeNode>();

    public void setTreeNode(int d, BoardStatus b, int x, int y, treeNode n){
        this.depth = d;
        this.board = b;
        this.stepX = x;
        this.stepY = y;
        this.tFather = n;
    }

    public void setRootNode(int d, BoardStatus b){
        this.depth = d;
        this.board = b;
    }



    public void setValue(int i) {this.value = i;}
    public void setDepth(int i) {this.depth = i;}
    public void setBoard(BoardStatus b) {this.board = b;}
    public void setStepX(int i) {this.stepX = i;}
    public void setStepY(int i) {this.stepY = i;}
    public void settFather (treeNode t) {this.tFather = t;}

    public int getValue() {return this.value;}
    public int getDepth() {return this.depth;}
    public BoardStatus getBoard() {return this.board;}
    public int getStepX() {return this.stepX;}
    public int getStepY() {return this.stepY;}

    public treeNode gettChildInIndex (int i) {return this.tChild.get(i);}
    public int getChildSize () {return  this.tChild.size();}

    public void addChild(treeNode n) {this.tChild.add(n);}
}
