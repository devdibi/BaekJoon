import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 누적합 테이블 구성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = map[i][j] + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }
        
        // M번의 구간 합 구하기
        int x1, y1, x2, y2, result;
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            result = map[x2][y2] - map[x1-1][y2] - map[x2][y1-1] + map[x1-1][y1-1];
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}