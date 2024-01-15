class Solution {
    int r = 0,c = 0;
    int rSize, cSize;
    public int[] solution(String[] keyinput, int[] board) {
        rSize = (board[0] - 1)/2;
        cSize = (board[1] - 1)/2;
        
        // 시작은 무조건 중앙
        // r = (rSize - 1) / 2;
        // c = (cSize - 1) / 2;
        
        for(String act : keyinput){
            move(act);
        }
        
        // return new int[]{r - (rSize-1)/2,c - (cSize-1)/2};
        return new int[]{r,c};
                
    }
    public void move(String act){
        if(act.equals("left")) r--;
        if(act.equals("right")) r++;
        if(act.equals("up")) c++;
        if(act.equals("down")) c--;
        
        if(r < -rSize) r = -rSize;
        if(r > rSize) r = rSize;
        if(c < -cSize) c = -cSize;
        if(c > cSize) c = cSize;
        // if(r < 0) r = 0;
        // if(r > rSize) r = rSize;
        // if(c < 0) c = 0;
        // if(c > cSize) c = cSize;
        
    }
}

