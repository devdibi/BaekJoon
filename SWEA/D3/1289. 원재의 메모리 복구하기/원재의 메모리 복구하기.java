import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            // 목표 메모리 값
            char[] destination = br.readLine().toCharArray();

            // 메모리 길이
            int len = destination.length;

            // boolean으로 설정
            boolean[] compare = new boolean[len];

            for (int i = 0; i < len; i++) {
                if (destination[i] == '0') {
                    compare[i] = true;
                }
            }

            // 비교 작업
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (compare[i])
                    continue;
                for (int j = i; j < len; j++) {
                    compare[j] = !compare[j];
                }
                cnt++;
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        
        System.out.println(sb);

    }

}
