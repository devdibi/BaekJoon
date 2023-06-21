import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R, X, arr[], result=0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // L <= 합 <= R
        // max - min >= X
        subset(0);
        System.out.println(result);

    }

    public static void subset(int cnt) {
        if (cnt == N) {
            int max = -1;
            int min = Integer.MAX_VALUE;
            int temp;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i])
                    continue;
                temp = arr[i];
                if (max < temp) {
                    max = temp;
                }
                if (min > temp) {
                    min = temp;
                }
                sum += temp;
            }
            if (L <= sum && sum <= R && max - min >= X) {
                result++;
            }

            return;
        }

        visited[cnt] = true;
        subset(cnt + 1);
        visited[cnt] = false;
        subset(cnt + 1);
    }
}