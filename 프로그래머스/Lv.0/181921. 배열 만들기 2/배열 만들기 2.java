import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        // 0과 5로만 이루어진 수가 그렇게 많은 편이아니다. => 하나의 자리수에 별로 없다.
        // 1. 가능한 자리수를 구한다.
        
        // 2. 0과 5로만 이루어진 수를 모두 구한다.
        
        // 3. 범위로 자른다
        
        // 맨앞자리는 무조건 5
        
        // 1자리 => 5
        // 2자리 => 50, 55
        // 3자리 => 500, 505, 550, 555
        // 4자리 => 5000,5005,5050,5055,5500,5505,5550,5555
        
        // 1,2,4,8,16,...개
        
        // 자리수가 증가할 수록 이전 수들이 뒤에 추가되는 경우의 수이다.
        List<Integer> total = new ArrayList<>();
        List<Integer> list;
        total.add(5);
        
        for(int i = 1; i < String.valueOf(r).length();i++){
            list = new ArrayList<>();
            int basic = (int)(5 * Math.pow(10,i));
            list.add(basic);
            for(int j = 0; j < total.size();j++){
                list.add(basic + total.get(j));
            }
            
            for(int j = 0; j < list.size(); j++){
                total.add(list.get(j));
            }
        }
        list = new ArrayList<>();
        for(int i = 0; i < total.size(); i++){
            if(total.get(i) < l) continue;
            if(total.get(i) > r) break;
            list.add(total.get(i));
        }
        if(list.size() == 0) return new int[]{-1};
        int[] answer = new int[list.size()];
        int idx = 0;
        for(Integer i : list){
            answer[idx++] = i;
        }
            
        return answer;
        
        
    }
}