import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> list = new ArrayList<>();
        
        // yellow가 가능한 세로의 길이 리스트 생성
        for(int i = 1; i <= yellow;i++){
            if(yellow / i < i) break; // 가로가 아닌 세로가 되는 전환점
            if(yellow % i == 0){
                list.add(i); // 가능한 세로의 길이 추가
            }
        }
        
        // 갈색의 공식 => 4(꼭짓점) + 모서리 (가로 + 세로) * 2
        for(int i : list){
            if(brown == (i + yellow/i) * 2 + 4){
                return new int[]{(yellow/i)+2,i+2};
            }
        }
        
        return null;
    }
}