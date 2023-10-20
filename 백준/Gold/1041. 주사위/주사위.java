import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 꼭짓점 4개(3개합 최소), 2개합 최소 (N-2) * 8 + 4개, 나머지 단면 = 최소값 * 6면체 단면수 * (N - 2) * (N - 2) + (N - 2) * 최소값 * 4

        // 0 - 5, 1 - 4, 2 - 3 인덱스 서로 건너편에 위치, 두 인덱스의 합이 5인 경우만 제외

        // 1. 최소값을 구한다,
        // 2. 2개 단면의 합의 최소를 구한다.
        // 3. 3개 단면의 합의 최소를 구한다.

        // 1, 2, 3, 4, 5, 6

        int N = Integer.parseInt(br.readLine());

        
        int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        long result = 0;

        if (N == 1) {
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < 6; i++) {
                result += dice[i];
                max = Math.max(max, dice[i]);
            }
            
            result -= max;
            System.out.println(result);
            System.exit(0);
        }
        
        int oneMin = Integer.MAX_VALUE; // 한개 최소
        int twoMin = Integer.MAX_VALUE; // 두개 최소 - 12가지 경우 비교 가능
        int threeMin = Integer.MAX_VALUE; // 세개 최소 - 8가지 경우 비교 가능

        for (int i = 0; i < 6; i++) {
            oneMin = Math.min(oneMin, dice[i]);
            
            for (int j = 0; j < 6; j++) {
                if (i == j || i + j == 5) {
                    continue;
                }
                twoMin = Math.min(dice[i] + dice[j], twoMin);
            }
        }

        // 세개
        int temp = Math.min(dice[0], dice[5]); // 마주보는 면 조사
        int tempMin = Integer.MAX_VALUE;

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (i == j || i + j == 5) {
                    continue;
                }
                tempMin = Math.min(dice[i] + dice[j], tempMin);
            }
        }
        
        threeMin = temp + tempMin;

        // 꼭짓점 4개(3개합 최소), 2개합 최소 (N-2) * 8 + 4개, 나머지 단면 = 최소값 * 6면체 단면수 * (N - 2) * (N - 2)

        result = (long)threeMin * 4 + (long)((N - 2) * 8 + 4) * twoMin + (long)oneMin * 5 * (N - 2) * (N - 2) + oneMin * (N-2) * 4;

        System.out.println(result);
    }
}