import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray();
        char[] T = br.readLine().toCharArray();

        // B
        // ABBA
        int idx = T.length - S.length;
        int status = 0;

        int end = T.length - 1;
        int start = 0;

        while (idx > 0) {
            idx--;
            if (status == 0) {
                if (T[end] == 'A') {
                    end--;
                    continue;
                }
                if (T[end] == 'B') {
                    end--;
                    // reverse
                    status = 1;
                    continue;
                }

            }
            if (status == 1) {
                if (T[start] == 'A') {
                    start++;
                    continue;
                }
                if (T[start] == 'B') {
                    start++;
                    status = 0;
                    continue;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (status == 0) {
            for (int i = start; i <= end; i++) {
                sb.append(T[i]);
            }
        }

        if (status == 1) {
            for (int i = end; i >= start; i--) {
                sb.append(T[i]);
            }
        }

        for (int i = 0; i < S.length; i++) {
            if (!(sb.charAt(i) == S[i])) {
                System.out.println(0);
                System.exit(0);
            }
        }
        
        System.out.println(1);

    }
    
}