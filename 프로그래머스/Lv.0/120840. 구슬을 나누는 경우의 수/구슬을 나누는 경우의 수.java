class Solution {
    public int solution(int balls, int share) {
        // balls C share
        return comb((double)balls, (double)share);
    }
    
    public int comb(double n, double r){
        double result = 1;
        double temp = n;
        
        // n!
        while(temp > 1){
            result *= temp;
            temp--;
        }
        
        temp = n - r;
        
        // n-r!
        while(temp > 1){
            result /= temp;
            temp--;
        }
        
        // r!
        while(r > 1){
            result /= r;
            r--;
        }
        
        return (int)Math.round(result);
    }
    
}