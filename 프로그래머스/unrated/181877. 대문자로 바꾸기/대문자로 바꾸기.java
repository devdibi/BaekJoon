import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        return Stream.of(myString).map(String::toUpperCase).reduce((a,b) -> a+b).orElse("");
    }
}