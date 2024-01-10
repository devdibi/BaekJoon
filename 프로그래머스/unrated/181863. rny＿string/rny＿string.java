import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String rny_string) {
        return rny_string
            .chars() // 문자열 IntStream으로 생성
            .mapToObj(c -> (char)c) // mapToObj로 문자로변경
            .map(ch -> ch == 'm'? "rn" : String.valueOf(ch)) // map으로 각각 적용
            .collect(Collectors.joining()); // collect를 통해서 문자열로 통합

    }
}