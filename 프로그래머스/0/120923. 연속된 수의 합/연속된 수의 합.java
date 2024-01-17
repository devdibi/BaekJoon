class Solution {
    public int[] solution(int num, int total) {
        int idx = total + num;
        // if(total == 0 && num == 1) return new int[]{0};
        // if(total == 0){
        //     int temp = (num -1) / 2;
        //     temp
        // }
        while(true){
            int sum = 0;
            for(int i = idx; i > idx - num; i--){
                sum += i;
            }
            if(sum == total){
                break;
            }else{
                idx--;
            }
        }
        
        int[] result = new int[num];
        int index = num-1;
        
        for(int i = idx; i > idx - num; i--){
            result[index--] = i;
        }
        return result;
    }
}