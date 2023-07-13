import java.util.*;
import java.io.*;

public class Main {
    static List<Loc> list;
    static char[][] map, check;
    static boolean[][] visited;
    static int ans = 0;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static boolean status = true;
    static class Loc {
        int r, c;
        char v;

        public Loc(int r, int c, char v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new LinkedList<>();

        map = new char[12][6];
        check = new char[12][6];
        visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                map[i][j] = temp[j];
                check[i][j] = temp[j];
                if (map[i][j] != '.') {
                    list.add(new Loc(i, j, temp[j]));
                }
            }
        }

        while (status) {
            int idx = 0;
            status = false;
            
            // bomb와 정렬
            while (idx < list.size()) {
                Loc puyo = list.get(idx++);
                search(puyo);
            }
            sort();
            
            list.clear();

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (check[i][j] != map[i][j]) {
                        status = true;
                    }
                    check[i][j] = map[i][j];
                    if (check[i][j] != '.') {
                        list.add(new Loc(i, j, check[i][j]));
                    }
                }
            }

            if (status) {
                ans++;
            }
        }
        
        System.out.println(ans);
        
        
        
    }
    
    public static void search(Loc puyo) {
        visited = new boolean[12][6];
        Queue<Loc> p = new LinkedList<>();
        
        // 개수
        int count = 1;
        p.offer(puyo);

        Loc cur;
        visited[puyo.r][puyo.c] = true;
        int nr, nc;
        
        // 없을때까지
        while (!p.isEmpty()) {
            cur = p.poll();
            // 4방 탐색
            for (int i = 0; i < 4; i++) {
                nr = cur.r + dr[i];
                nc = cur.c + dc[i];

                // 범위 초과
                if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6) {
                    continue;
                }

                // 방문여부 판별
                if (visited[nr][nc]) {
                    continue;
                }

                // 일치 여부 판별
                if (map[nr][nc] != puyo.v) {
                    continue;
                }

                visited[nr][nc] = true;
                p.offer(new Loc(nr, nc, map[nr][nc]));
                count++;
            }

        }

        if (count >= 4) {
            bomb(visited);
        } 
    }
    
    public static void bomb(boolean[][] visited) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visited[i][j]) {
                    map[i][j] = '.';
                }
            }
        }
    }
    
    public static void sort() {
        for (int i = 0; i < 6; i++) {
            Queue<String> sq = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    sq.offer("" + map[j][i]);
                }
                map[j][i] = '.';
            }

            int idx = 11;
            while (!sq.isEmpty()) {
                map[idx--][i] = sq.poll().toCharArray()[0];
            }
        }
    }
}
    