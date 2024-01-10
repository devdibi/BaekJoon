class Solution {
    public int[] solution(int[] arr, int k) {
        int idx = 0;
        if(k % 2 !=0){
            for(int i : arr){
                arr[idx++] = i*k;
            }
        }else{
            for(int i : arr){
                arr[idx++] = i+k;
            }
        }
        return arr;
    }
}