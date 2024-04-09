import java.util.*;

class Solution {
    char[] nums; // 문자열 => 문자 배열
    int len; // 문자열 전체의 길이
    HashSet<Integer> result = new HashSet<>(); // 숫자 저장
    boolean[] visited; // 방문 배열
    int[] select; // 선택
    
    public int solution(String numbers) {
        // 숫자 분할
        nums = numbers.toCharArray();
        len = nums.length;
        visited = new boolean[len];
        
        // 순열을 통해 모든 경우의 수 체크
        for(int i = 1; i <= len; i++){
            select = new int[i];
            per(0,i);
        }
    
        return result.size();
    }
    
    // 자릿수에 따른 모든 경우의 수
    public void per(int cnt, int size){
        if(cnt == size){
            // 숫자 생성
            StringBuilder sb = new StringBuilder();
            
            for(int n : select){
                sb.append(nums[n]);
            }
            
            int num = Integer.parseInt(sb.toString());
            
            // 소수 판별
            if(check(num)) result.add(num);
            
            return;
        }
        
        for(int i = 0; i < len; i++){
            if(visited[i]) continue;
            
            int temp = select[cnt];
            select[cnt] = i;
            visited[i] = true;
            per(cnt + 1, size);
            select[cnt] = temp;
            visited[i] = false;
        }
    }
    // 소수 판별
    public boolean check(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        
        int temp = (int) Math.sqrt(n); // n의 제곱근
        
        for(int i = 2; i <= temp; i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
    
    
}