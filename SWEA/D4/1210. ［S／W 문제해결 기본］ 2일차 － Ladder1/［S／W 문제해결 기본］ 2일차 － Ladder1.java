import java.io.*;
import java.util.*;



public class Solution{
    static int[][] map;
    static int[] r = {0 ,0, -1}; // 좌, 우, 상
    static int[] c = {-1, 1, 0}; // 좌, 우, 상

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        for(int t = 1; t <= 10; t++){
            // TC 번호
            t = Integer.parseInt(br.readLine());

            // map
            map = new int[100][100];

            // start
            int idx = 99; // 행
            int start = 0; // 열

            // map 입력
            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 2){
                        start = j;
                    }
                }
            }


            // 99 -> 0
            while(idx > 0){
                // 현재 방문함
                map[idx][start] = -1;
    
                // 상, 좌, 우 탐색
                for(int j = 0; j < 3; j++){
                    if(idx+r[j] < 0 || start+c[j] < 0 || idx+r[j] >= 100 || start+c[j] >= 100) continue; // 범위 초과 제거

                    if(map[idx+r[j]][start+c[j]] == 1){
                        // 좌표 갱신
                        idx = idx + r[j];
                        start = start + c[j];
                        break;
                    }
                }

            }
            sb.append("#").append(t).append(" ").append(start).append("\n");
        }
        System.out.println(sb);
    }
}