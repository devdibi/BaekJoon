import java.util.*;
import java.io.*;

public class Main {
    static double a = 0,b = 0,ans = 0;

    static class Loc {
        double x, y;

        public Loc(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Loc[] map = new Loc[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i] = new Loc(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        int idx = 0;

        map[N] = map[0];

        while (idx < N) {
            a += map[idx].x * map[idx + 1].y;
            b += map[idx].y * map[idx + 1].x;
            idx++;
        }

        ans = Math.abs(a - b) / 2.0;
        
        String result = String.format("%.1f", ans);
        System.out.println(result);
    }
}
