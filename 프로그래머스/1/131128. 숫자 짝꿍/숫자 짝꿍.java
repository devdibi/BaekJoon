import java.util.*;

class Solution {
    int[] xArr = new int[10];
    int[] yArr = new int[10];
    List<Integer> list = new ArrayList<>();
    
    public String solution(String X, String Y) {
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        
        // 숫자 종류 탐색
        for(int i = 0; i < x.length; i++){
            xArr[x[i] - 48]++;
        }
        
        for(int i = 0; i < y.length; i++){
            yArr[y[i] - 48]++;
        }
        
        // 일치 숫자 파악
        for(int i = 0; i < 10; i++){
            int min = Math.min(xArr[i], yArr[i]);
            
            while(min > 0){
                list.add(i);
                min--;
            }
        }
        if(list.size() == 0){
            return "-1";
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        if(list.get(0) == 0){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(Integer i : list){
            sb.append(i);
        }
        return sb.toString();
    }
}