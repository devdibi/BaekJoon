import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();        
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 기본 정보 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 숫자 정보 입력 및 누적합 생성
        int[] number = new int[N+1];
        st = new StringTokenizer(br.readLine());
        
        number[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            number[i] = number[i-1] + Integer.parseInt(st.nextToken());
        }

        // M번의 구간합 구하기
        int start, end, result;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            result = number[end] - number[start-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}