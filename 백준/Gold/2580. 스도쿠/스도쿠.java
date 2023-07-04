import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        dfs(0, 0);

        
    }

    public static void dfs(int row, int col) {
        // 모든 행, 열 탐색 종료
        if (row == 9) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            
            System.out.println(sb);
            System.exit(0);
            return;
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    map[row][col] = i;
                    if (col < 8) {
                        dfs(row, col + 1);
                    } else {
                        dfs(row + 1, 0);
                    }
                    map[row][col] = 0;
                }
            }
        } else {
            if (col < 8) {
                dfs(row, col + 1);
            } else {
                dfs(row + 1, 0);
            }
        }

    }

    // 유효성검사
    public static boolean check(int row, int col, int val) {
        // 가로
        for (int i = 0; i < 9; i++) {
            if (val == map[row][i]) {
                return false;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            if (val == map[i][col]) {
                return false;
            }
        }
        // 구간
        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (val == map[i][j]) {
                    return false;
                }
            }
        }

        return true;

    }

}