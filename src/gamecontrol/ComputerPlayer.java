package gamecontrol;

public class ComputerPlayer {

    private boolean cutOffOccured;
    private boolean maxDepthReached;
    private int totalGenerateNodes;
    private int pruneMax;
    private int pruneMin;




    public int ABCPruneSearch(){
        int minUtility = -1000;
        int maxUtility = 1000;



    }

    public int maxValue(int a, int b){

    }

   // public int ABMaxValue(node)


    public void setCutOffOccured(boolean cutOffOccured1){
        this.cutOffOccured = cutOffOccured1;
    }

    public boolean getCutOffOccured(){
        return this.cutOffOccured;
    }

    public void setMaxDepthReached(boolean maxDepthReached1){
        this.maxDepthReached = maxDepthReached1;
    }
    public boolean getMaxDepthReached(){
        return this.maxDepthReached;
    }

    public void setTotalGenerateNodes(int i){
        this.totalGenerateNodes = i;
    }

    public int getTotalGenerateNodes(){
        return this.totalGenerateNodes;
    }

    public void setPruneMax(int p){
        this.pruneMax = p;
    }

    public int getPruneMax(){
        return pruneMax;
    }

    public void setPruneMin(int p){
        this.pruneMin = p;
    }

    public int getPruneMin(){
        return pruneMin;
    }
}
