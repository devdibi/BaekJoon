import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 도시의 개수
        n = Integer.parseInt(br.readLine());

        // 지도
        map = new int[n+1][n+1];

        // 버스의 개수
        m = Integer.parseInt(br.readLine());

        // 최대값으로 채우기
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], 100_000_000);
        }

        int r, c, val;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            val = Integer.parseInt(st.nextToken());

            if (map[r][c] > val) {
                map[r][c] = val;
            }
        }
        
        // 플로이드 워샬
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (k == i) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (k == j) {
                        continue;
                    }

                    if (i == j) {
                        continue;
                    }
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 최대 제거
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] >= 100_000_000) {
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
