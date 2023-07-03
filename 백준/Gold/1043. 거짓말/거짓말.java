import java.util.*;
import java.io.*;

class Main {
    static int N, M, start, len, result = 0;
    static boolean[] visited;
    static boolean[] truth;
    static boolean[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수
        N = Integer.parseInt(st.nextToken());

        // 파티 수
        M = Integer.parseInt(st.nextToken());
        
        map = new boolean[M+1][N+1];

        // 진실을 아는 사람 배열
        visited = new boolean[N+1];

        // 진실을 아는 파티
        truth = new boolean[M+1];

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= start; i++){
            int num = Integer.parseInt(st.nextToken());
            visited[num] = true;
        }

        // 입력
        for(int i = 1; i <= M; i++){
           st = new StringTokenizer(br.readLine());
           len = Integer.parseInt(st.nextToken());
            // 파티 진실 판별 여부 파악
            for(int j = 0; j < len; j++){
                int idx = Integer.parseInt(st.nextToken());
                map[i][idx] = true;
            }
        }

        int check = start;

        // M개의 파티 확인
        for(int i = 1; i <= M; i++){
            // 현재 파티에서 진실을 아는 사람이 있는지 판별
            for(int j = 1; j <= N; j++){
                if(visited[j] && map[i][j]){
                    truth[i] = true;
                    break;
                }
            }

            if(truth[i]){
                for(int j = 1; j <= N; j++){
                    if(!visited[j] && map[i][j]){
                        visited[j] = true;
                        check += 1;
                    }
                }
            }
        }

        // 진실을 아는 사람이 추가되지 않을때까지 수행
        while(start != check){
            start = check;
            // M개의 파티 확인
            for(int i = 1; i <= M; i++){
                // 현재 파티에서 진실을 아는 사람이 있는지 판별
                for(int j = 1; j <= N; j++){
                    if(visited[j] && map[i][j]){
                        truth[i] = true;
                        break;
                    }
                }

                if(truth[i]){
                    for(int j = 1; j <= N; j++){
                        if(!visited[j] && map[i][j]){
                            visited[j] = true;
                            check += 1;
                        }
                    }
                }
            }
        }

        // 최종 확인
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N;j++){
                if(visited[j] && map[i][j]){
                    result++;
                    break;
                }
            }
        }

        System.out.println(M - result);
    }
    
}