import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int angle = Integer.parseInt(st.nextToken());

            // 방향 지정
            int d = 1;

            if(angle < 0){
                d -= 2;
            }

            int cnt = Math.abs(angle) / 45;

            int[][] map = new int[n][n];

            // 배열 입력
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(angle % 360 != 0){
                for(int i = 0; i < cnt; i++){
                    map = turn(map, d);
                }
            }
            print(map, n);

        }

    }

    // 시계방향으로 45도 메서드 구현
    public static int[][] turn(int[][] map, int d){
        int n = map.length;
        // 복사
        int[][] temp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = map[i][j];
            }
        }

        if(d > 0){
            for(int i = 0; i < n; i++){
                temp[i][n/2] = map[i][i]; // \ 대각선 -> | 직선
                temp[i][n - i - 1] = map[i][n/2]; // | 직선 -> / 대각선
                temp[n/2][i] = map[n - i - 1][i]; // / 대각선 -> - 직선
                temp[i][i] = map[n/2][i]; // - 직선 -> \ 대각선
            }

        } else{
            for(int i = 0; i < n; i++){
                temp[n/2][i] = map[i][i]; // \ 대각선 -> - 직선
                temp[n - i - 1][i] = map[n/2][i]; // - 직선 -> / 대각선
                temp[i][n/2] = map[i][n - i - 1]; // / 대각선 -> | 직선
                temp[i][i] = map[i][n/2]; // | 직선 -> \ 대각선
            }
        }
        return temp;
    }

    public static void print(int[][] map, int n){
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n;j++){
                sb.append(map[i][j]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}