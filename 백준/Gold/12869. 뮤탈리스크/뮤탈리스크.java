import java.util.*;
import java.io.*;

public class Main {
    static int N, ans = 0;
    static Integer map[], dp[][][];
    static int[][] attack = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 9, 3 }, { 1, 3, 9 } };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new Integer[3];
        dp = new Integer[61][61][61];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // scv
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = N; i < 3; i++) {
            map[i] = 0;
        }

        // hp
        for (int i = 0; i < 61; i++) {
            for(int j = 0; j < 61;j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        int ans = att(map, 0);
        System.out.println(ans);
    }

    public static int att(Integer[] scv, int cnt) {
        if (check(scv)) {
            return cnt;
        }

        Arrays.sort(scv, Collections.reverseOrder());

        if (dp[scv[0]][scv[1]][scv[2]] != Integer.MAX_VALUE) {
            return dp[scv[0]][scv[1]][scv[2]];
        }

        for (int i = 0; i < 6; i++) {
            Integer[] temp = new Integer[3];
            temp[0] = Math.max(scv[0] - attack[i][0], 0);
            temp[1] = Math.max(scv[1] - attack[i][1], 0);
            temp[2] = Math.max(scv[2] - attack[i][2], 0);
            dp[scv[0]][scv[1]][scv[2]] = Math.min(dp[scv[0]][scv[1]][scv[2]], att(temp,cnt+1));
        }
        return dp[scv[0]][scv[1]][scv[2]];
    }

    public static boolean check(Integer[] scv) {
        for (int i = 0; i < N; i++) {
            if (scv[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
    