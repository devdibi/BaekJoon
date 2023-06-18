import java.util.*;
import java.io.*;

public class Main {
    static int[] result = new int[7];
    static int[] map = new int[9];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        comb(0, 0);
    }

    public static void comb(int cnt, int start) {
        if (cnt == 7) {
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += result[i];
            }
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            result[cnt] = map[i];
            comb(cnt + 1, i + 1);
        }
    }
}