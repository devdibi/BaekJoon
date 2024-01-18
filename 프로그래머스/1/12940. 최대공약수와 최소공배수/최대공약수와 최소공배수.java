class Solution {
    public int[] solution(int n, int m) {
         // 큰 값을 설정
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        int lcm = 1;
        boolean status = false;
        
        while(true){
            status = false;
            for(int i = 2; i < max; i++){
                if(min % i == 0 && max % i == 0){
                    lcm *= i;
                    max /= i;
                    min /= i;
                    status = true;
                    break;
                }
                
            }
            if(!status) break;
        }
        
        int gcd = min * max * lcm;
        return new int[]{lcm, gcd};
    }
}