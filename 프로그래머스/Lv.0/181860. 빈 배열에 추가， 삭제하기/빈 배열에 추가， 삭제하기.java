import java.util.*;
import java.util.stream.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int[] arr, boolean[] flag) {
        
        
        for(int i = 0; i < arr.length; i++){
            if(flag[i]){
                add(arr[i]);
            }else{
                remove(arr[i]);
            }
        }
        int len = stack.size();
        int[] result = new int[len];
        
        for(int i = len - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
    public void add(int i){
        int idx = 0;
        while(idx < i * 2){
            stack.add(i);
            idx++;
        }
    }
    
    public void remove(int i){
        while(i > 0){
            stack.pop();
            i--;
        }
    }
}