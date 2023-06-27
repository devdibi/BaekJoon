import java.util.*;
import java.io.*;

public class Main {
    static String[] start;
    static int[] min;
    static int money = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // start 00:00 
        // min int(1 <= D <= 4320)

        // 60으로 나누었을 때 몫 + 1(나머지가 1이라도 있을 경우)
        // 야갼 10시(22:00 ~ 08:00) 5000원
        start = new String[N];
        min = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = st.nextToken();
            min[i] = Integer.parseInt(st.nextToken());
        }

        String[] temp = new String[2];
        int beginTime = 0;
        for (int i = 0; i < N; i++) {
            money = 0;
            temp = start[i].split(":");
            beginTime = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            cal((int)beginTime, min[i]);
            sb.append(money * 1000).append("\n");
        }
        System.out.println(sb);

    }

    public static void cal(int begin, int time) {
        while (time > 0) {
        if (begin < 180) {
          if (time > 240) {
            time -= 480 - begin;
            begin = 481;
            money += 5;
          } else {
            money += (time + 59) / 60;
            time = 0;
          }
        } else if (begin >= 1320) {
          if (time > 240) {
            time -= (1440 - begin + 480);
            begin = 481;
            money += 5;
          } else {
            money += (time + 59) / 60;
            time = 0;
          }
        } else {
          time -= 60;
          begin += 60;
          money += 1;
        }
      }
            
    }

}