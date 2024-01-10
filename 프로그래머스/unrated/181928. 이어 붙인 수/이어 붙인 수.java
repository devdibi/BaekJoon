import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        String odd = Arrays.stream(num_list)
            .filter(num -> num % 2 != 0)
            .mapToObj(String::valueOf)
            .reduce("",(a,b) -> a+b);
        
        String even = Arrays.stream(num_list)
            .filter(num -> num % 2 == 0)
            .mapToObj(String::valueOf)
            .reduce("",(a,b) -> a+b);  
        return Integer.parseInt(odd) + Integer.parseInt(even);
        
    }
}