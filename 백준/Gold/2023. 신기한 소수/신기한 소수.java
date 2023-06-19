import java.util.*;
import java.io.*;

public class Main {
    // 모든 자리수가 소수인 소수
    // 소수란 약수가 자기 자신과 1 뿐인 수
    // 1, 2, 3, 4, 5, 6, 7, 8, 9
    // 맨 앞 가능한 수 = 2,3,5,7
    static int[] first = { 2, 3, 5, 7 };
    // 두번째 이상으로 가능한 수 1,3,7,9
    static int[] num = { 1, 3, 7, 9 };
    static int N;
    static int[] result;
    static StringBuilder sb = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();
        result = new int[N];

        for (int i = 0; i < 4; i++) {
            result[0] = first[i];
            permutation(1);
        }

        System.out.println(sb);
        sc.close();
    }

    public static void permutation(int cnt) {
        if (cnt == N) {
            if (check()) {
                for (int i = 0; i < N; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            result[cnt] = num[i];
            permutation(cnt + 1);
        }
    }
    public static boolean check(){
        // 숫자 생성
        int temp = result[0];
        int sqrt;
        for (int i = 1; i < N; i++) {
            temp = temp * 10 + result[i];
            sqrt = (int) Math.sqrt(temp);
            for (int j = 3; j < sqrt; j += 2) {
                if (temp % j == 0) {
                    return false;
                }
            }
        }
        return true; 
    }
    
}