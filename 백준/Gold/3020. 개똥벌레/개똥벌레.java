import java.util.*;
import java.io.*;

public class Main{
    static int N, H, top[], bottom[], result[], min, cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Integer.MAX_VALUE;
        cnt = 0;
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        result = new int[H];
        
        top = new int[H+2];
        bottom = new int[H+2];

        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine())+1]++;
        }

        for (int i = 1; i <= H; i++) {
            bottom[i] += bottom[i - 1];
        }

        for (int i = H; i >= 1; i--) {
            top[i] += top[i + 1];
        }

        int result;

        for (int i = 1; i <= H; i++) {
            result = (bottom[H] - bottom[i - 1]) + (top[1] - top[i + 1]);

            if (min > result) {
                min = result;
                cnt = 0;
            }

            if (result == min) {
                cnt++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(cnt);
        System.out.println(sb);
    }
}