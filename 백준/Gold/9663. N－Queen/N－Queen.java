import java.util.*;
import java.io.*;

public class Main{
    static int N, count = 0;
    static int[] visited;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        visited = new int[N];

        dfs(0);
        System.out.println(count);

    }
    public static void dfs(int cnt){
        if(cnt == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            // 임의의 위치에 배치
            visited[cnt] = i;

            // 판별하여 놓을 수 있으면 배치
            if(check(cnt)){
                dfs(cnt+1);
            }
            
        }
    }

    public static boolean check(int cnt){
        for(int i = 0; i < cnt; i++){
            // 상하좌우
            if(visited[cnt] == visited[i]){
                return false;
            }
            // 대각선
            else if(Math.abs(visited[cnt] - visited[i]) == Math.abs(cnt - i)){
                return false;
            }
        }
        return true;
    }
}