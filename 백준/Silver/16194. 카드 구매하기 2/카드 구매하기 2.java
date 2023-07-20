import java.util.*;
import java.io.*;

public class Main {
    static int N, map[], result[], ans = Integer.MAX_VALUE, count=0, max = 0;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i] == -1 || dp[i] > dp[i - j] + map[j]) {
                    dp[i] = dp[i - j] + map[j];
                }
            }
        }
        
        System.out.println(dp[N]);
    }


}
