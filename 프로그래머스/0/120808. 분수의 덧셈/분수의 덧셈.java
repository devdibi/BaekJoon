class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int bottom = denom1 * denom2;
        
        int top = numer1 * denom2 + numer2 * denom1;
        
        int min = Math.min(top,bottom);
        
        boolean status = true;
        
        while(true){
            status = false;
            for(int i = 2; i < min; i++){
                if(top % i == 0 && bottom % i == 0){
                    top /= i;
                    bottom /= i;
                    status = true;
                }
            }
            if(!status) break;
        }
        
        return new int[]{top,bottom};
        
    }
}