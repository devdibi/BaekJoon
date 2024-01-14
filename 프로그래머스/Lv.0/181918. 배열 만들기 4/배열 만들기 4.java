import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        List<Integer> list = new ArrayList<>();
        
        while(i < arr.length){
            if(list.size() == 0){
                list.add(arr[i]);
                i++;
            }else{
                if(list.get(list.size()-1) < arr[i]){
                    list.add(arr[i]);
                    i++;
                }else{
                    list.remove(list.get(list.size()-1));
                }
            }
        }
        int[] result = new int[list.size()];
        for(int l = 0; l < list.size(); l++){
            result[l] = list.get(l);
        }
        return result;
    }
}