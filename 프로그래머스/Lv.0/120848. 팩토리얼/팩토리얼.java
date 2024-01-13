class Solution {
    public int solution(int n) {
        return factorial(n);
    }
    
    public int factorial(int i){
        if(i == 1) return 1;
        
        int num = 1;
        int val = 1;
        while(i > val){
            val *= num++;
            if(val > i){
                num--;
            }
        }
        return num -1 ;
    }
}