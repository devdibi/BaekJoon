import java.util.*;
import java.io.*;

public class Main {
    static int N, C;
    static int[] map,temp;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(map);

        int low = 1;
        int high = map[N - 1] - map[0] + 1;
        while (low < high) {
            int mid = (high + low) / 2;

            if (find(mid) < C) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low - 1);

    }

    public static int find(int d) {
        int count = 1;
        int loc = map[0];

        for (int i = 1; i < map.length; i++) {
            int now = map[i];

            if (now - loc >= d) {
                count++;
                loc = now;
            }
        }
        return count;
    }
}
