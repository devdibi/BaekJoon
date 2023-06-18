import java.util.*;
import java.io.*;

public class Main {
    static int result[], N, M, map[], sum, answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);

        System.out.println(answer);
    }

    public static void comb(int cnt, int start) {
        if (cnt == 3) {
            sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += result[i];
            }

            if (sum > M) {
                return;
            }
            
            if (Math.abs(answer - M) > Math.abs(sum - M)) {
                answer = sum;
            }
            
            return;
        }

        for (int i = start; i < N; i++) {
            result[cnt] = map[i];
            comb(cnt + 1, i + 1);
        }
    }
}