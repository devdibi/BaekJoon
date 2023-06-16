import java.util.*;
import java.io.*;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int max, min, max_idx, min_idx;
    static int[] map;
 
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int cnt = 0;
            // 최소 최대 설정
            max = -1;
            min = 101;
            max_idx = 0;
            min_idx = 0;
 
            map = new int[100];
            // dump
            int dump = Integer.parseInt(br.readLine());
 
            // map 입력 및 최대 최소 파악
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i] = temp;
 
                if (temp > max) {
                    max = temp;
                    max_idx = i;
                }
                if (temp < min) {
                    min = temp;
                    min_idx = i;
                }
            }
             
            // 수행
            while (min != max && cnt < dump) {
                // dump
                map[max_idx]--;
                map[min_idx]++;
                cnt++;
 
                max = -1;
                min = 101;
 
                // check
                for (int i = 0; i < 100; i++) {
                    if (map[i] < min) {
                        min = map[i];
                        min_idx = i;
                    }
                    if (map[i] > max) {
                        max = map[i];
                        max_idx = i;
                    }
                }
 
            }
            sb.append("#").append(t).append(" ").append(max - min).append("\n");
        }
        System.out.println(sb);
    }
}