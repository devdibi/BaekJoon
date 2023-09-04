import java.util.*;
import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < T; t++){
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            // 입력 완료

            long ans = 1;

            while (pq.size() > 1) {
                long A = pq.poll();
                long B = pq.poll();
                long temp = A * B;
                
                ans *= temp % MOD;
                ans %= MOD;
                pq.offer(temp);
                
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);

    }

}