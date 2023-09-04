import java.util.*;
import java.io.*;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int N, M, K;
    static char map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        char[] arr;
        for (int i = 0; i < N; i++) {
            arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = arr[j];
            }
        }


        int ans = Math.min(set(make('B')),set(make('W')));

        System.out.println(ans);

    }

    public static int[][] make(char word) {
        int[][] temp = new int[N + 1][M + 1];

        int now = 0;

        // 배열 만들기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    if (map[i][j] == word) {
                        now = 0;
                    } else {
                        now = 1;
                    }
                } else {
                    if (map[i][j] == word) {
                        now = 1;
                    } else {
                        now = 0;
                    }
                }
                temp[i + 1][j + 1] = temp[i + 1][j] + temp[i][j + 1] - temp[i][j] + now;
            }
        }
        return temp;
    }

    public static int set(int[][] temp) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                // diff
                int tmp = temp[i - 1][j - 1] - temp[i + K - 1][j - 1] - temp[i - 1][j + K - 1] + temp[i + K - 1][j + K - 1];
                min = Math.min(tmp, min);
            }
        }
        return min;
    }

}