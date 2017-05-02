package gamecontrol;


/**
 * BoardStatus class is the class for board status.
 * Every game will have one BoardStatus instance to record board status now time.
 * Also it will have several BoardStatus instances for the game tree computing. (Each tree node contains a BoardStatus for board info)
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
 *
 * Computer (or the max player) have the X symbol and the human player have the O symbol.
 * value of board position: 0-not set 1-X 10-O
 */

public class BoardStatus {
    private int[][] board = new int[4][4]; //4x4 board
    //value of board position: 0-not set 1-X 10-O
    private int utility; //utility value of this board status
    private int eval;   //eval value of this board status

    //several set/get methods for private values
    public void setUtility(int j) {this.utility = j;}
    public int getUtility() {return this.utility;}

    public void setEval(int j) {this.eval = j;}
    public int getEval() {return this.eval;}

    /*
     * Methods for set and get the value of a specific position (x, y) in board
     * value of board position: 0-not set 1-X 10-O
     */
    public void setBoardOne(int j,int k, int value) {this.board[j][k] = value;}
    public int getBoardOne(int j, int k) {return this.board[j][k];}


    /*
     * Methods for unset the value of a specific position (x, y) in board
     * This method will be used in algorithm calculating process
     */
    public void unSetBoardOne(int j, int k) {this.board[j][k] = 0;}


    /*
     * 2 small methods for testing if one specific position (x, y) is X (value 1) or O (value 10)
     * This two methods will be used in the following methods for game terminal test.
     */
    public boolean ifBoardOneX(int j, int k){
        if (this.getBoardOne(j,k)== 1)
            return true;
        else return false;
    }

    public boolean ifBoardOneO(int j, int k){
        if (this.getBoardOne(j, k) == 10)
            return true;
        else return false;
    }

    /*
     * The following 7 methods are used for eval value computing function.
     */

    /* Small method for testing if one line is full filled by X. Same method ifOLine is for O test.
     * This method will be used for game terminal test.
     * @param int j: line number (0-3)
     */
    public boolean ifXLine(int j){
        if (this.ifBoardOneX(0,j) && this.ifBoardOneX(1,j) && this.ifBoardOneX(2,j) && this.ifBoardOneX(3,j))
            return true;
        else return false;
    }

    /*
     * Small method for testing if one column is full filled by X. Same method ifOLine is for O test.
     * This method will be used for game terminal test.
     * @param int k: column number (0-3)
     */
    public boolean ifXColumn(int k){
        if (this.ifBoardOneX(k,0) && this.ifBoardOneX(k,1) && this.ifBoardOneX(k,2) && this.ifBoardOneX(k,3))
            return true;
        else return false;
    }

    /*
     * Small method for testing if either diagonal line is full filled by X. Same method ifOLine is for O test.
     * This method will be used for game terminal test.
     */
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

    //small method for test if board is full filled by X or O
    // used for game terminal test
    public boolean ifBoardFull(){
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j<=3;j++){
                if (getBoardOne(i, j) == 0)
                    return false;
            }
        }
        return true;
    }


    /*
     *The following 4 methods are used for eval value computing function.
     */

    /* Small method for computing one line sum value.
     * This method will be used for game eval value computing function.
     * @param int j: line number (0-3)
     * For example, one line have 3 Xs and zero O, the sum value will be 1+1+1 = 3.
     */
    public int getLineValue(int j) {
        int sum=0;
        for (int k=0;k<=3;k++){
            sum=sum+this.getBoardOne(j, k);
        }
        return sum;
    }

    /* Small method for computing one column sum value.
     * This method will be used for game eval value computing function.
     * @param int k: column number (0-3)
     * For example, one line have 3 Os and zero X, the sum value will be 10+10+10 = 30.
     */
    public int getColumnValue(int k){
        int sum=0;
        for (int j=0;j<=3;j++){
            sum=sum+this.getBoardOne(j, k);
        }
        return sum;
    }

    /* Small method for computing 45 degree diagonal line sum value. (method name wrongly written as 35....)
     * This method will be used for game eval value computing function.
     */
    public int getDiago35(){
        int sum=0;
        for (int j=0;j<=3;j++){
            sum=sum+this.getBoardOne(j, j);
        }
        return sum;
    }

    /* Small method for computing 135 degree diagonal line sum value. (method name wrongly written as 145....)
     * This method will be used for game eval value computing function.
     */
    public int getDiago145() {
        int sum = 0;
        for (int j = 0; j <= 3; j++) {
            sum = sum + this.getBoardOne(j, 3 - j);
        }
        return sum;
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
                || this.ifXDiago()) {
            result = 1;
            this.setUtility(1000);
        }
        //test O win
        else if (this.ifOLine(0) || this.ifOLine(1) || this.ifOLine(2) || this.ifOLine(3)
                || this.ifOColumn(0) || this.ifOColumn(1) || this.ifOColumn(2) || this.ifOColumn(3)
                || this.ifODiago()) {
            result = 2;
            this.setUtility(-1000);
        }
        //test draw: board is full
        else if (this.ifBoardFull()) {
            result = 3;
            this.setUtility(0);
        }
        else
            result = 0;

        return result;

    }

    /*
     * computeEval(): compute eval value
     */
    public void computeEval(){
        int evaluate;
        int x3=0;
        int x2=0;
        int x1=0;
        int o3=0;
        int o2=0;
        int o1=0;


        for (int i=0;i<=3;i++){
            int lineValue = this.getLineValue(i);
            int columnValue = this.getColumnValue(i);
            if (lineValue==3) x3=x3+1;          //only 3 Xs and zero O in this line
            else if (lineValue==2) x2=x2+1;     //only 2 Xs and zero O in this line
            else if (lineValue==1) x1=x1+1;     //only 1 X and zero O in this line
            else if (lineValue==30) o3=o3+1;    //only 3 Os and zero X in this line
            else if (lineValue==20) o2=o2+1;    //only 2 Os and zero X in this line
            else if (lineValue==10) o1=o1+1;    //only 1 O and zero X in this line

            if (columnValue==3) x3=x3+1;        //only 3 Xs and zero O in this column
            else if (columnValue==2) x2=x2+1;   //only 2 Xs and zero O in this column
            else if (columnValue==1) x1=x1+1;   //only 1 X and zero O in this column
            else if (columnValue==30) o3=o3+1;  //only 3 Os and zero X in this column
            else if (columnValue==20) o2=o2+1;  //only 2 Os and zero X in this column
            else if (columnValue==10) o1=o1+1;  //only 1 O and zero X in this column
        }


        int diago35 = this.getDiago35();
        if (diago35==3) x3=x3+1;                //only 3 Xs and zero O in this diagonal line
        else if (diago35==2) x2=x2+1;           //only 2 Xs and zero O in this diagonal line
        else if (diago35==1) x1=x1+1;           //only 1 X and zero O in this diagonal line
        else if (diago35==30) o3=o3+1;          //only 3 Os and zero X in this diagonal line
        else if (diago35==20) o2=o2+1;          //only 2 Os and zero X in this diagonal line
        else if (diago35==10) o1=o1+1;          //only 1 O and zero X in this diagonal line

        int diago145 = this.getDiago145();
        if (diago145==3) x3=x3+1;               //only 3 Xs and zero O in this diagonal line
        else if (diago145==2) x2=x2+1;          //only 2 Xs and zero O in this diagonal line
        else if (diago145==1) x1=x1+1;          //only 1 Xs and zero O in this diagonal line
        else if (diago145==30) o3=o3+1;         //only 3 Os and zero X in this diagonal line
        else if (diago145==20) o2=o2+1;         //only 2 Os and zero X in this diagonal line
        else if (diago145==10) o1=o1+1;         //only 1 O and zero X in this diagonal line

        evaluate = 6*x3+3*x2+1*x1-(6*o3+3*o2+1*o1); //computer eval value
        this.setEval(evaluate);
    }


    /* Method for copy value from one board instance to another board instance.
     * Because '=' will only do the shallow copy.
     * To make deep copy (or clone), I simple design this method instead of use clone() method with is more confused.
     * @param: BoardStatus anotherBoard: the board instance will be copied from.
     */
    public void copyValueFrom(BoardStatus anotherBoard) {
        this.setEval(anotherBoard.getEval());
        this.setUtility(anotherBoard.getUtility());
        for (int i=0; i<=3; i++){
            for (int j=0; j<=3; j++){
                this.setBoardOne(i, j, anotherBoard.getBoardOne(i, j));
            }
        }
    }


}
