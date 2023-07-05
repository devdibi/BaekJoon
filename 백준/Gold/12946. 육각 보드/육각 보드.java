import java.util.*;
import java.io.*;

public class Main{
    static int[][] color;
    static String[][] map;
    static int N, max = 0;
    // 방향은 6방향으로 진행한다.
    // (-1, 0), (-1, 1), (0, 1), (1, 0), (1,-1), (0,-1)
    static int[] dr = {-1, -1, 0, 1, 1, 0};
    static int[] dc = {0, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        color = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] st = br.readLine().split("");
            for(int j = 0; j < N; j++){
                map[i][j] = st[j];
                color[i][j] = -1;
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j].equals("X") && color[i][j] == -1){
                    dfs(i,j,0);
                }
            }
        }
    
        System.out.println(max);
    }
    public static void dfs(int row, int col, int val){
        color[row][col] = val;
        max = max < 1 ? 1 : max;

        int nr, nc;
        for(int i = 0; i < 6; i++){
            nr = row + dr[i];
            nc = col + dc[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N){
                continue;
            }

            if(!map[nr][nc].equals("X")){
                continue;
            }

            if(color[nr][nc] == -1 ) {
                dfs(nr,nc,1-val);
            }
            max = max < 2 ? 2 : max;

            if(color[nr][nc] == val){
                max = max < 3 ? 3 : max;
            }
        }
    }
}