import java.util.*;
import java.io.*;

public class Main {
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];

        int front, back;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            front = Integer.parseInt(st.nextToken());
            back = Integer.parseInt(st.nextToken());

            map[front][back] = 1;
            map[back][front] = -1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (map[k][i] != 0 && map[j][i] == map[i][k]) {
                        map[j][k] = map[j][i];
                    }
                }
            }
        }
        
        int[] up = new int[N + 1];
        int[] down = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    up[i]++;
                }
                if (map[i][j] == -1) {
                    down[i]++;
                }
            }
        }

        int temp = (N / 2) + 1;
        
        for (int i = 1; i <= N; i++) {
            if (up[i] >= temp) {
                ans++;
            }

            if (down[i] >= temp) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}