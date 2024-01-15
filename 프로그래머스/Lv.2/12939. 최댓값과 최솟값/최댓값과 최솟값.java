import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        
        int[] list = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(list);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(list[0]).append(" ").append(list[list.length - 1]);
        return sb.toString();
    }
}