import java.util.*;
import java.io.*;

public class Main {
    static int N, map[], result[], ans = Integer.MIN_VALUE;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[N];
        result = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        per(0);

        System.out.println(ans);
    }

    public static void per(int cnt) {
        if (cnt == N) {
            int idx = 0;
            int max = 0;
            while (idx < N-1) {
                max += Math.abs(result[idx++] - result[idx]);
            }

            if (ans < max) {
                ans = max;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            int temp = result[cnt];
            result[cnt] = map[i];
            visited[i] = true;
            per(cnt + 1);
            visited[i] = false;
            result[cnt] = temp; 

        }
    }
        
}