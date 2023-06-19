import java.util.*;
import java.io.*;

public class Solution {
    static int TC, N, L, max;
    static int[] score, cal;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        TC = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= TC; t++) {
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            score = new int[N];
            cal = new int[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            subset(0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static void subset(int cnt) {
        if (cnt == N) {
            int s = 0;
            int c = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    s += score[i];
                    c += cal[i];
                }
                if (c > L) {
                    return;
                }
            }
            if (s > max) {
                max = s;
            }
            return;
        }

        visited[cnt] = true;
        subset(cnt + 1);
        visited[cnt] = false;
        subset(cnt + 1);
        
    }
}
