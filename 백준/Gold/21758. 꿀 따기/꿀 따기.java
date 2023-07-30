import java.util.*;
import java.io.*;

public class Main {
    static long[] left, right, map;
    static int N;
    static long max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        left = new long[N];
        right = new long[N];
        map = new long[N];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        left[0] = map[0];
       for (int i = 1; i < N; i++) {
            left[i] = map[i] + left[i - 1];
        } 

        right[N - 1] = map[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            right[i] = map[i] + right[i + 1];
        }
        one();
        two();
        three();

        System.out.println(max);
    }

    static long oneTotal, twoTotal;
    public static long one() {
        int idx = 1;

        while (idx < N - 1) {
            oneTotal = left[N - 1] - map[0] - map[idx];
            twoTotal = left[N - 1] - left[idx];

            max = Math.max(oneTotal + twoTotal, max);
            idx++;
        }
        return max;
    }

    public static long two() {
        int idx = 1;
        while (idx < N - 1) {
            oneTotal = right[0] - map[N - 1] - map[idx];
            twoTotal = right[0] - right[idx];

            max = Math.max(oneTotal + twoTotal, max);
            idx++;
        }
        return max;
    }

    public static long three() {
        int idx = 1;
        while (idx < N - 1) {
            oneTotal = left[idx] - map[0];
            twoTotal = right[idx] - map[N - 1];

            max = Math.max(oneTotal + twoTotal, max);
            idx++;
        }
        return max;
    }
}
