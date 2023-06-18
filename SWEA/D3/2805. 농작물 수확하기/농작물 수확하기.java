import java.util.*;
import java.io.*;

public class Solution {
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            int result = 0;
            int N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] temp = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = (int) temp[j] - 48;
                }
            }
            
            // 중간 라인
            for (int i = 0; i < N; i++) {
                result += map[N / 2][i];
            }


            // 상, 하
            for (int i = 1; i <= N / 2; i++) {
                for (int j = i; j < N - i; j++) {
                    // 상단
                    result += map[N / 2 - i][j];
                    // 하단
                    result += map[N / 2 + i][j];
                }
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }    
}
