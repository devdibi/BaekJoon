import java.util.*;

class Solution {
    int[] array;
    public int solution(int[] arr) {
        array = arr; // 배열을 전역 변수화
        
        Arrays.sort(array); // 배열정렬
        
        int lcm = lcm(); // 최대 공약수를 계산
        
        for(int i = 0; i < array.length; i++){
            lcm *= array[i]; // 최대 공약수에 나머지 값을 곱한다.
        }
        
        return lcm;
    }
    public int lcm(){
        int lcm = 1; // 최소 공배수
        
        int idx = 2; // 2 이상의 값으로 시작
        
        while(idx <= 100){
            boolean[] visited = new boolean[array.length]; // 나눠졌는지 여부 파악
            
            int cnt = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] % idx == 0){ // idx가 약수인지 판별
                    visited[i] = true;
                    cnt++;
                }
            }
            
            if(cnt > 1){
                lcm *= idx;
                for(int i = 0; i < array.length; i++){
                    if(visited[i]) array[i] /= idx;
                }
            }else{
                idx++;
            }
        }
        return lcm;   
    }
}