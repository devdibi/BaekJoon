import java.util.*;
import java.io.*;

public class Main {
    static int H, W, N;      // 높이, 너비, 움직임의 최대 횟수
    static char map[][];     // 지도
    static int dr[] = { -1, 1, 0, 0 }; // 상, 하, 좌, 우 | W, S, A, D
    static int dc[] = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
    static int[][] direction;

    // 위치 저장 객체
    static class Loc {
        int r, c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int result[];
    static Loc D, Z; // 다오와 디즈니

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H + 1][W + 1];
        
        for (int i = 1; i <= H; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= W; j++) {
                map[i][j] = temp[j-1];
                if (temp[j - 1] == 'D') {
                    D = new Loc(i, j);
                    continue;
                }
                if (temp[j - 1] == 'Z') {
                    Z = new Loc(i, j);
                    continue;
                }
            }
        }

        N = Integer.parseInt(br.readLine());
        result = new int[N+1];
        direction = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            direction[i][0] = set(st.nextToken());
            direction[i][1] = set(st.nextToken());
        }
        dfs(1);
        System.out.println("NO");
        // 입력 완료
    }

    public static void dfs(int cnt) {
        if (cnt == N+1) {
            StringBuilder sb = new StringBuilder();

            int nr = D.r, nc  = D.c;

            for (int i = 1; i <= N; i++) {
                nr += dr[direction[i][result[i]]];
                nc += dc[direction[i][result[i]]];

                if (nr < 1 || nc < 1 || nr > H || nc > W) {
                    return;
                }

                if (map[nr][nc] == '@') {
                    return;
                }

                sb.append(convert(direction[i][result[i]]));

                if (map[nr][nc] == 'Z') {
                    System.out.println("YES");
                    System.out.println(sb);
                    System.exit(0);
                }
            }

            return;
        }

        for (int i = 0; i <= 1; i++) {
            result[cnt] = i;
            dfs(cnt + 1);
        }
    }

    // 방향의 배열을 정하는 메서드
    public static int set(String d) {
        if (d.equals("W")) { // 상
            return 0;
        } else if (d.equals("S")) { // 하
            return 1;
        } else if (d.equals("A")) { // 좌
            return 2;
        } else if (d.equals("D")) { // 우
            return 3;
        }
        return -1;
    }
    // 방향의 문자값을 변환하는 메서드
    public static char convert(int i) {
        if (i == 0) { // 상
            return 'W';
        } else if (i == 1) { // 하
            return 'S';
        } else if (i == 2) { // 좌
            return 'A';
        } else if (i == 3) { // 우
            return 'D';
        }
        return ' ';
    }
}
