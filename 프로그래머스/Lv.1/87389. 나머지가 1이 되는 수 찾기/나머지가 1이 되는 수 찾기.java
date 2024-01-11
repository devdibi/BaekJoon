class Solution {
    public int solution(int n) {
        int temp = 3;
        
        if(n % 2 != 0){
            return 2;
        }
        
        while(true){
            if(n % temp == 1){
                return temp;
            }
            temp++;
        }
        
    }
}