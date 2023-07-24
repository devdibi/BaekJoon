import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] map = br.readLine().toCharArray();

        long[] dp = new long[3];

        long result = 0;

        for(int i = 0; i < N; i++){
            if(map[i] == 'W'){
                dp[0]++;
                dp[0] %= MOD;
            }

            else if(map[i] == 'H'){
                dp[1] += dp[0];
                dp[1] %= MOD;
            }

            else if(map[i] == 'E'){
                result += dp[2];
                dp[2] *= 2;
                dp[2] += dp[1];
                dp[2] %= MOD;
            }
            result %= MOD;
        }
        System.out.println(result);
    }
}
