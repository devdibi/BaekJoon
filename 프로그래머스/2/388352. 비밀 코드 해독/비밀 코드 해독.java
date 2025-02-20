import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        return dfs(n, 0, 1, q, ans, new int[5]);
    }
    
    public int dfs(int n, int cnt, int start, int[][] q, int[] ans, int[] arr) {
        if(cnt == 5) {
            Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            return IntStream.range(0, q.length).allMatch(i -> (int) Arrays.stream(q[i]).filter(set::contains).count() == ans[i]) ? 1 : 0;
        }
        
        int result = 0;
        for(int i = start; i <= n; i++) {
            arr[cnt] = i;
            result += dfs(n, cnt+1, i + 1, q, ans, arr);
            arr[cnt] = 0;
        }
        return result;
    }
}