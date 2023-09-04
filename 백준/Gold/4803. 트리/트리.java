import java.util.*;
import java.io.*;

public class Main {
    static int[] map;
    static int N, M;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            // node 생성
            map = new int[N+1];

            for (int i = 0; i <= N; i++) {
                map[i] = i;
            }   

            // cycle 
            Queue<Integer> cycle = new LinkedList<>();

            // 공통 부모 찾기
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 부모 찾기
                a = find(a);
                b = find(b);

                // cycle 판별
                if (a != b) {
                    union(a, b);
                } else {
                    cycle.offer(a);
                }
            }

            // 갱신
            for (int i = 0; i <= N; i++) {
                find(i);
            }

            // 탐색하지 않아도 되는 값 추가
            HashSet<Integer> hs = new HashSet<>();

            while (!cycle.isEmpty()) {
                hs.add(map[cycle.poll()]);
            }

            cnt = 0;

            for (int i = 1; i <= N; i++) {
                if (hs.contains(map[i])) {
                    continue;
                }
                cnt++;
                hs.add(map[i]);
            }

            if (cnt > 1) {
                sb.append("Case " + t + ": A forest of " + cnt + " trees.").append("\n");
            } else if (cnt == 1) {
                sb.append("Case " + t + ": There is one tree.").append("\n");
            } else {
                sb.append("Case " + t + ": No trees.").append("\n");
            }
            t++;
        }
        System.out.println(sb);
    }
    
    // 부모 찾기
    public static int find(int x) {
        if (x != map[x]) {
            map[x] = find(map[x]);
        }
        return map[x];
    }

    // 공통 부모 설정
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) {
                map[x] = y;
            }else{
                map[y] = x;
            }
        }
    }
}
