import java.util.*;
import java.io.*;

class Main {
    static int N, map[], result, min = Integer.MAX_VALUE;
    static boolean status;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        map = new int[N];
        for(int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        // map[0]에 -1을 한 등차수열 부터 시작
        int a = map[0] - 1;

        // 최대 공차 구하기
        double temp = ((double)(map[N-1] - map[0]))/(N-1);
        int d = (int)Math.round(temp);

        int[] compare = new int[N];
        int cnt = 0;
        // -1, 0, 1 조사
        while(cnt < 3){
            result = 0;
            status = false;

            // 비교 수열 생성
            for(int i = 0; i < N; i++){
                compare[i] = a + i*d;
            }

            // 가능한 수열인지 판별
            for(int i = 0; i < N; i++){
                if(Math.abs(map[i] - compare[i]) < 2){
                    continue;
                }
                status = true;
            }

            // 가능한 수열의 경우 변환된 숫자의 개수 파악
            if(!status){
                for(int i = 0; i < N; i++){
                    if(map[i] != compare[i]){
                        result++;
                        continue;
                    }
                }
            }else{
                a++;
                cnt++;
                continue;
            }

            if(min > result){
                min = result;
            }
            
            a++;
            cnt++;
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
}