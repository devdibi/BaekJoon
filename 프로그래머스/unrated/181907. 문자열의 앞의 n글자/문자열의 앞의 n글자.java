import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int n) {
        return my_string.chars()
                .limit(n)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }
}