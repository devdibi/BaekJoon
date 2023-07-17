import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, map[][];
    static int count = 0;
    static Queue<Loc> queue = new LinkedList<>();
    static List<Loc> one = new LinkedList<>();
    static List<Loc> two = new LinkedList<>();
    static boolean[][] visited;
    static Loc spot;
    static int r, c;
    static class Loc {
        int r, c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void toStr(){
            System.out.println(r + " " + c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        spot = new Loc(0, 0);

        int row = 0;
        int col = 0;

        // 맵 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            row = 0;
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    row++;
                    count++;
                }
            }

            if (row > 0) {
                col++;
            }
        }

        int dot = K * 2 - count;

        // 겹치는게 없는 경우
        if (dot == 0) {
            System.out.println(0);
            System.exit(0);
        }

        // 크로스 하는 경우
        if (dot == 1 && col > 1) {
            // 행 탐색
            for (int i = 1; i <= N; i++) {
                count = 0;
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 1) {
                        count++;
                    }
                }
                if (count >= K) {
                    spot.r = i;
                    break;
                }
            }

            // 열 탐색
            for (int i = 1; i <= M; i++) {
                count = 0;
                for (int j = 1; j <= N; j++) {
                    if (map[j][i] == 1) {
                        count++;
                    }
                    if (count >= K) {
                        spot.c = i;
                        break;
                    }
                }
            }

            System.out.println(1);
            System.out.println(spot.r + " " + spot.c);
            System.exit(0);
        }

        if (dot >= 1) {
            int status = 0;

            // 행 탐색
            for (int i = 1; i <= N; i++) {
                count = 0;
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 1) {
                        count++;
                    }
                }

                if (count >= K) {
                    status = 1;
                    r = i;
                    break;
                }
            }
            if (status != 1) {
                // 열 탐색
                for (int i = 1; i <= M; i++) {
                    count = 0;
                    for (int j = 1; j <= N; j++) {
                        if (map[j][i] == 1) {
                            count++;
                        }
                    }
                    if (count >= K) {
                        status = 2;
                        c = i;
                        break;
                    }
                }
            }

            // 행이 겹치는 경우
            if (status == 1) {
                for (int i = 1; i <= M; i++) {
                    if (map[r][i] == 0) {
                        continue;
                    }
                    one.add(new Loc(r, i));
                }
            } else if (status == 2) {
                // 열이 겹치는 경우
                for (int i = 1; i <= N; i++) {
                    if (map[i][c] == 0) {
                        continue;
                    }
                    one.add(new Loc(i, c));
                }
            }

            // 출력
            System.out.println(dot);
            int len = one.size() - K;
            for (int i = len; i < len + dot; i++) {
                System.out.println(one.get(i).r + " " + one.get(i).c);
            }
        }
    }
}

