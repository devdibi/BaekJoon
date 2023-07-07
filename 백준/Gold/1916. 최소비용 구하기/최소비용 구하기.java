import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][], start, end, d[];
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 도시의 개수
        N = Integer.parseInt(br.readLine());

        // 버스의 개수
        M = Integer.parseInt(br.readLine());

        // 지도 그리기
        map = new int[N + 1][N + 1];

        int r, c, v;

        // 지도 입력(최대값으로 채우기)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                map[i][j] = INF;
            }
        }

        // 간선 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if (map[r][c] == INF) {
                map[r][c] = v;
            } else {
                map[r][c] = Math.min(map[r][c], v);
            }
        }

        // 출발 및 도착
        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 출발과 종료가 같을 경우 종료
        if (start == end) {
            System.out.println(0);
            System.exit(0);
        }

        // 거리 배열
        d = new int[N + 1];

        // 방문 배열
        visited = new boolean[N + 1];

        // 시작 노드 지정 및 방문
        d[start] = 0;
        visited[start] = true;

        // 시작노드와 연결된 간선 체크
        for (int i = 1; i <= N; i++) {
            if (i == start) {
                continue;
            }
            d[i] = map[start][i];
        }
        for (int k = 0; k < N - 1; k++) {
            di(idxFind());
        }

        // 전체 찾기
        System.out.println(d[end]);
    }

    public static void di(int idx) {
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            if (map[idx][i] != INF) {
                d[i] = Math.min(d[i], d[idx] + map[idx][i]);
            }
        }
    }

    public static int idxFind() {
        int idx = -1;
        int min = INF;
        // 최소값 찾기
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            if (min >= d[i]) {
                min = d[i];
                idx = i;
            }
        }
        visited[idx] = true;
        return idx;
    }
}
