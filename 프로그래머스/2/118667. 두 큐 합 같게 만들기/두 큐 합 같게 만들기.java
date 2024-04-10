class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        
        long one = 0;
        long two = 0;
        
        for(int i = 0; i < len; i++){
            one += queue1[i];
            two += queue2[i];
        }
        
        // 총합이 홀수이면 불가
        if((one + two) % 2 != 0) return -1;
        
        // 목표 값
        long target = (one + two)/2;
        
        // 초기 큐의 총합을 기준으로 작은 값이 앞으로 큰값이 뒤로
        int[] total = new int[len * 2];
        
        if(one < two){
            for(int i = 0; i < len; i++){
                total[i] = queue1[i];
                total[i + len] = queue2[i];
            }
        }else{
            for(int i = 0; i < len; i++){
                total[i] = queue2[i];
                total[i + len] = queue1[i];
            }
        }
        
        // 투포인터 활용
        int left = 0;
        int right = len -1;
        
        // 현재 기준 값 = 작은값
        long now = (long) Math.min(one, two);
        int cnt = 0;
        
        while(left <= right){
            if(now < target){
                right++;
                if(right == 2 * len) return -1; // index 초과 방지
                now += total[right];
                cnt++;
                continue;
            }
            
            if(now > target){
                now -= total[left];
                left++;
                cnt++;
                continue;
            }
            
            if(now == target) return cnt;
        }
        
        return -1;
    }
}