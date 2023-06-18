import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        comb(0, 1);
    }

    public static void comb(int cnt, int start) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= N; i++) {
            int temp = result[cnt];
            result[cnt] = i;
            comb(cnt + 1, i + 1);
            result[cnt] = temp;
        }
    }
}