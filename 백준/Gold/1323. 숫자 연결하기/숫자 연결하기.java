import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Long> set = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        
        long num = N % K;
        
        while (true) {
            ans++;
            num %= K;
            
            if (num == 0) {
                break;
            }
            // 반복 여부 판별
            if (!set.add(num)) {
                ans = -1;
                break;
            }

            String temp = Long.toString(num) + Integer.toString(N);
            num = Long.parseLong(temp);
        }
        System.out.println(ans);
    }
}
