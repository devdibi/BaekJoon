import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        
        int front, back, sum, result, count = 0;

        // 한 수를 양끝에서 차이를 좁히며 총 n^2 활용
        for (int i = 0; i < num.length; i++) {
            result = num[i];
            front = 0;
            back = N - 1;
            sum = 0;

            while (front < back) {
                sum = num[front] + num[back];

                // 같은 경우
                if (sum == result) {
                    if (i == front) {
                        front++;
                    } else if (i == back) {
                        back--;
                    }
                    else {
                        count++;
                        break;
                    }

                }
                if (num[front] + num[back] > result) {
                    back--;
                    continue;
                }
                if (num[front] + num[back] < result) {
                    front++;
                }

            }
        }

        System.out.println(count);
    }
}