import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int[] solution(int[] lottos, int[] win_nums) {
        // 등수 생성
        map.put(6,1);
        map.put(5,2);
        map.put(4,3);
        map.put(3,4);
        map.put(2,5);
        map.put(1,6);
        map.put(0,6);
        
        int blank = 0; // 가려진 번호
        int min = 0; // 최소 일치 번호
        
        for(int i : lottos){
            // 번호가 가려진 경우
            if(i == 0){
                blank++;
                continue;
            }
            
            // 번호가 일치하는 경우
            if(contains(win_nums,i)){
                min++; 
            }
        }

        return check(blank, min);
    }
    
    public boolean contains(int[] lottos, int num){
        for(int i : lottos){
            if(i == num){
                return true;
            }
        }
        return false;
    }
    
    public int[] check(int blank, int min){
        int[] result = new int[2];
        
        // 최대 등수
        result[0] = map.get(min + blank);
        
        // 최소 등수
        result[1] = map.get(min);
        
        return result;
    }
}