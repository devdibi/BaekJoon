import java.util.*;
import java.io.*;

public class Main {
    // A, C, G, T
    // 문자열의 개수는 특정 수 이상
    static int N, M, num[], result;
    static String base[];
    static Queue<String> password;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        base = br.readLine().split("");

        // A, C, G, T
        num = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 시작 비밀번호
        password = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            password.offer(base[i]);
            cal(base[i]);
        }
        
        // 시작 비밀번호 체크
        if (check())
            result++;

        // 서열 이동
        String out;
        for (int i = M; i < N; i++) {
            out = password.poll();
            switch (out) {
                case "A":
                    num[0]++;
                    break;
                case "C":
                    num[1]++;
                    break;
                case "G":
                    num[2]++;
                    break;
                case "T":
                    num[3]++;
                    break;
            }
            password.offer(base[i]);
            cal(base[i]);
            if (check())
                result++;
        }
        System.out.println(result);


    }

    public static void cal(String base) {
        switch (base) {
            case "A":
                num[0]--;
                break;
            case "C":
                num[1]--;
                break;
            case "G":
                num[2]--;
                break;
            case "T":
                num[3]--;
                break;
        }
    }

    public static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (num[i] > 0) {
                return false;
            }
        }
        return true;
    }

}