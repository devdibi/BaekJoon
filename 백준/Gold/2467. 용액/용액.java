import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        int result = Math.abs(map[left] + map[right]);
        
        int l = map[left];
        int r = map[right];
        
        while (left < right) {
            if (Math.abs(map[left] + map[right]) < result) {
                result = Math.abs(map[left] + map[right]);
                l = map[left];
                r = map[right];
            }
            else {
                if (Math.abs(map[left + 1] + map[right]) < Math.abs(map[left] + map[right - 1])) {
                    left++;
                }
                else if (Math.abs(map[left + 1] + map[right]) > Math.abs(map[left] + map[right - 1])) {
                    right--;
                }
                else {
                    left++;
                    right--;
                }
            }
        }

        System.out.println(l + " " + r);
    }

}
