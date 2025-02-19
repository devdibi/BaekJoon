import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int aMax = 0;
        int bMax = 0;
        
        for (int[] item : info) {
            aMax += item[0];
            bMax += item[1];
        }
        
        int[][] arr = new int[len + 1][aMax + 1];
        
        for (int i = 0; i <= len; i++) {
            Arrays.fill(arr[i], bMax + 1);
        }
        
        arr[0][0] = 0;
        
        for (int i = 0; i < len; i++) {
            int a = info[i][0];
            int b = info[i][1];
            
            for (int j = 0; j <= aMax; j++) {
                if (arr[i][j] <= bMax) {
                    if (j + a <= aMax) {
                        arr[i+1][j+a] = Math.min(arr[i+1][j+a], arr[i][j]);
                    }
                    
                    arr[i+1][j] = Math.min(arr[i+1][j], arr[i][j] + b);
                }
            }
        }
        
        int minA = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[len][i] < m) {
                minA = i;
                break;
            }
        }
        
        return minA == Integer.MAX_VALUE ? -1 : minA;
    }
}