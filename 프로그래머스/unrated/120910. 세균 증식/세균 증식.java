import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int t) {
        OptionalInt result = IntStream.iterate(n, a -> 2 * a)
            .limit(t+1)
            .reduce((x,y) -> y);
        
        return result.getAsInt();
    }
}