import java.util.*;
import java.io.*;

public class Main {
    static int N, A[], B[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        B = new int[N];
        // 배열 B를 A로 변경하자
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        // 횟수
        int count = 0;

        while (!result()) {
            if (check()) {
                divine();
            } else {
                minus();
            }
            count++;
        }
        System.out.println(count);

    }
    
    // 종료 판별
    public static boolean result() {
        for (int i = 0; i < N; i++) {
            if (B[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 홀수 판별(홀수 = false, 짝수 = true)
    public static boolean check() {
        for (int i = 0; i < N; i++) {
            if (B[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    // 모두가 짝수일 경우 반으로 나눈다.
    public static void divine() {
        for (int i = 0; i < N; i++) {
            B[i] = B[i] / 2;
        }
    }
    
    // 홀수가 하나라도 있으면 1을 뺀다
    public static void minus() {
        for (int i = 0; i < N; i++) {
            if (B[i] % 2 != 0) {
                B[i] -= 1;
                return;
            }
        }
    }
}
