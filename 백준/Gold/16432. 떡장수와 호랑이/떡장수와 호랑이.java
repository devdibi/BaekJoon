import java.util.*;
import java.io.*;

public class Main {
    static int N, result[];
    static boolean[][] map, visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int len;
        map = new boolean[N][10];
        visited = new boolean[N][10];
        result = new int[N];
        for (int i = 0; i < N; i++) {
            len = sc.nextInt();
            for (int j = 0; j < len; j++) {
                map[i][sc.nextInt()] = true;
            }
        }

        dfs(0, -1);

        System.out.println(-1);
    }

    public static void dfs(int cnt, int selected) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (!map[cnt][i] || i == selected || visited[cnt][i]) {
                continue;
            }

            result[cnt] = i;
            visited[cnt][i] = true;
            dfs(cnt + 1, i);
        }
    }

}