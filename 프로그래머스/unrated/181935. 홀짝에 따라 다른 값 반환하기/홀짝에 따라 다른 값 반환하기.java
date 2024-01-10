import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n) {
        if(n % 2 != 0){
            return IntStream.rangeClosed(1,n).filter(num -> num % 2 != 0).sum();
        }else{
            return IntStream.rangeClosed(1,n).filter(num -> num % 2 == 0).map(a -> a* a).sum();
        }
    }
}