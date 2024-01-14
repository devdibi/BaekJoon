class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        
        int len = 1;
        
        while(n > len){
            len *= 2;
        }
        
        int[] result = new int[len];
        
        for(int i = 0; i < n; i++){
            result[i] = arr[i];
        }
        return result;
    }
}