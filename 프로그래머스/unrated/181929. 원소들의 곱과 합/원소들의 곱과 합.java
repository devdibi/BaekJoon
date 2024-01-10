import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum() * Arrays.stream(num_list).sum();
        int product = Arrays.stream(num_list).reduce((a,b) -> a*b).orElse(-1);
        
        return sum > product ? 1 : 0;
    }
}