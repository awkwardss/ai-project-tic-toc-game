package gamecontrol;

/**
 * BoardStatus class is the class for board status.
 * It contains methods: putOne
 *
 * Board map
 * -------------------------
 * |(0,0)|(0,1)|(0,2)|(0,3)|
 * -------------------------
 * |(1,0)|(1,1)|(1,2)|(1,3)|
 * -------------------------
 * |(2,0)|(2,1)|(2,2)|(2,3)|
 * -------------------------
 * |(3,0)|(3,1)|(3,2)|(3,3)|
 * -------------------------
 *
 */
public class BoardStatus {
    private int[][] board = new int[4][4]; //board
    //value of board: 0:not set 1:X 2:O
    private int utility;

    public void setBoardOne(int j,int k, int value){
        this.board[j][k] = value;
    }

    public int getBoardOne(int j, int k){
        return this.board[j][k];
    }

    public boolean ifBoardOneX(int j, int k){
        if (this.getBoardOne(j,k)== 1)
            return true;
        else return false;
    }

    public boolean ifBoardOneO(int j, int k){
        if (this.getBoardOne(j, k) == 2)
            return true;
        else return false;
    }

    public boolean ifXLine(int j){
        if (this.ifBoardOneX(0,j) && this.ifBoardOneX(1,j) && this.ifBoardOneX(2,j) && this.ifBoardOneX(3,j))
            return true;
        else return false;
    }

    public boolean ifXColumn(int k){
        if (this.ifBoardOneX(k,0) && this.ifBoardOneX(k,1) && this.ifBoardOneX(k,2) && this.ifBoardOneX(k,3))
            return true;
        else return false;
    }

    public boolean ifXDiago(){
        if ((this.ifBoardOneX(0,0) && this.ifBoardOneX(1,1) && this.ifBoardOneX(2,2) && this.ifBoardOneX(3,3))
            ||(this.ifBoardOneX(0,3) && this.ifBoardOneX(1,2) && this.ifBoardOneX(2,1) && this.ifBoardOneX(3,0)))
            return true;
        else return false;
    }

    public boolean ifOLine(int j){
        if (this.ifBoardOneO(0,j) && this.ifBoardOneO(1,j) && this.ifBoardOneO(2,j) && this.ifBoardOneO(3,j))
            return true;
        else return false;
    }

    public boolean ifOColumn(int k){
        if (this.ifBoardOneO(k,0) && this.ifBoardOneO(k,1) && this.ifBoardOneO(k,2) && this.ifBoardOneO(k,3))
            return true;
        else return false;
    }

    public boolean ifODiago(){
        if ((this.ifBoardOneO(0,0) && this.ifBoardOneO(1,1) && this.ifBoardOneO(2,2) && this.ifBoardOneO(3,3))
                ||(this.ifBoardOneO(0,3) && this.ifBoardOneO(1,2) && this.ifBoardOneO(2,1) && this.ifBoardOneO(3,0)))
            return true;
        else return false;
    }

    public boolean ifBoardFull(){
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j<=3;j++){
                if (getBoardOne(i, j) == 0)
                    return false;
            }
        }
        return true;
    }

    public void setUtility(int j){
        this.utility = j;
    }

    public int getUtility(){
        return this.utility;
    }

    /*
     * putOne: put one dot with value xo in place [x, y]
     * @param int x: x value of the position
     * @param int y: y value of the position
     * @param int xo: value of the position 0-not set 1-X 2-O
     */
    //
    public void putOne (int x, int y, int xo){
        this.setBoardOne(x, y, xo);
    }

    /*
     * isTerminal: find if the game is end
     * return: 0-not terminal; 1-X win; 2-O win; 3-draw
     */
    public int isTerminal(){
        int result;

        //test X win
        if (this.ifXLine(0) || this.ifXLine(1) || this.ifXLine(2) || this.ifXLine(3)
            || this.ifXColumn(0) || this.ifXColumn(1) || this.ifXColumn(2) || this.ifXColumn(3)
                || this.ifXDiago())
            result = 1;
        //test O win
        else if (this.ifOLine(0) || this.ifOLine(1) || this.ifOLine(2) || this.ifOLine(3)
                || this.ifOColumn(0) || this.ifOColumn(1) || this.ifOColumn(2) || this.ifOColumn(3)
                || this.ifODiago())
            result = 2;
        //test draw: board is full
        else if (this.ifBoardFull())
            result = 3;
        else
            result = 0;

        return result;

    }
}
