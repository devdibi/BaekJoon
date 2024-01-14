class Solution {
    public int solution(int[] arr) {
        int idx = 0;
        boolean status = false;
        int cnt = 0;
        while(true){
            idx = 0;
            status = false;
            for(int i : arr){
                if(i >= 50 && i % 2 == 0){
                    arr[idx] = i / 2;
                    status = true;
                }

                if(i < 50 && i % 2 != 0){
                    arr[idx] = i * 2 + 1;
                    status = true;
                }
                idx++;
            }
            if(!status){
                return cnt;
            }
            cnt++;
        }
        
    }
}