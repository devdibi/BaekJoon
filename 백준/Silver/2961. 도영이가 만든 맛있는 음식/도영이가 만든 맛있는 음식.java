import java.util.*;
import java.io.*;

public class Main {
    // 신맛은 곱, 쓴맛은 합 이 차이를 작게하라
    static int N, S[], B[], min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);

        System.out.println(min);
    }
    
    public static void subset(int cnt) {
        if (cnt == N) {
            int s = 1;
            int b = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i])
                    continue;
                s *= S[i];
                b += B[i];
            }
            if (s != 0 && b != 0) {
                min = Math.min(min, Math.abs(s - b));
            }
            return;
        }

            // 선택
            visited[cnt] = true;
            subset(cnt + 1);

            // 선택하지 않음
            visited[cnt] = false;
            subset(cnt + 1);
    }
}