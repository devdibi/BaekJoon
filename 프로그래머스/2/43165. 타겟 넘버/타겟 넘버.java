/*
    풀이
        n개의 음이 아닌 정수, 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들고자 한다.
        완전 탐색을 통해 모든 경우의 수를 확인한다(n < 20)
*/

import java.util.*;

class Solution {
    // 입력값 전역변수화
    int[] nums; // 정수 배열
    int n; // 정수 배열의 길이
    int t; // 타겟 값 
    
    // 완전탐색 활용 배열
    boolean[] selected; // + (true) / - (false) 선택 배열
    
    // 결과값
    int count = 0; // 결과
    
    public int solution(int[] numbers, int target) {
        nums = numbers; // 배열
        n = nums.length; // 길이
        t = target; // 타겟
        
        selected = new boolean[n]; // 정수 배열
        
        // 완전 탐색 수행
        dfs(0);
        
        return count;
    }
    
    public void dfs(int cnt){
        if(cnt == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(selected[i]){
                    sum += nums[i];
                }else{
                    sum -= nums[i];
                }
            }
            
            if(sum == t){
                count++;
            }
            return;
        }
        
        for(int i = 0; i < 2; i++){
            if(i == 0){
                selected[cnt] = true;    
            }
            dfs(cnt+1);
            selected[cnt] = false;
        }
    }
    
}