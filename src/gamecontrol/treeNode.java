package gamecontrol;

import java.util.ArrayList;

/**
 * The node constructor of the game tree
 * Tree node will only be used in αβ-cutoff-algorithm game tree.
 */
public class treeNode {
    private int value;
    private int depth;
    private BoardStatus board;
    private int stepX;
    private int stepY;

    private treeNode tFather;
    private ArrayList<treeNode> tChild;


    /*
     * Method for node value setting
     * @param d: depth for this node in game tree
     * @param b: the game board info for this node
     * @param x: the x value of choice position for this node
     * @param y: the y value of choice position for this node
     * @param n: the father node of this node
     */
    public void setTreeNode(int d, BoardStatus b, int x, int y, treeNode n){
        this.depth = d;
        this.board = b;
        this.stepX = x;
        this.stepY = y;
        this.tFather = n;
        tChild = new ArrayList<>();
    }


    /*
     * Another method for node value setting
     * @param d: depth for this node in game tree
     * @param b: the game board info for this node
     */
    public void setRootNode(int d, BoardStatus b){
        this.depth = d;
        this.board = b;
        tChild = new ArrayList<>();
    }


    //several get/set methods for private values of this class

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

    public void addChild(treeNode n) {this.tChild.add(n);}
    public ArrayList<treeNode> gettChild() {return tChild;}
}
