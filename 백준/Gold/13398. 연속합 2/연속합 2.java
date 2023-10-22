import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n]; 
        int[] dp2 = new int[n]; 

        dp1[0] = arr[0];
        dp2[0] = 0;

        int maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(arr[i], dp1[i - 1] + arr[i]);
            dp2[i] = Math.max(dp1[i - 1], dp2[i - 1] + arr[i]);
            maxSum = Math.max(maxSum, Math.max(dp1[i], dp2[i]));
        }

        System.out.println(maxSum);
    }
}