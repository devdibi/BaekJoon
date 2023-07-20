import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static Flower map[];
    static long nowNum = 0;
    static long nowCost = 0;
    static class Flower implements Comparable<Flower>{
        long num, cost;
        public Flower(long num, long cost) {
            this.num = num;
            this.cost = cost;
        }

        public int compareTo(Flower f) {
            return this.num < f.num ? 1 : -1;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());

        map = new Flower[2];
        for (int i = 0; i < 2; i++) {
            map[i] = new Flower(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        Flower A, B;

        // 효율 선택
        if (map[0].cost * map[1].num > map[1].cost * map[0].num) {
            A = new Flower(map[1].num, map[1].cost);
            B = new Flower(map[0].num, map[0].cost);
        } else {
            A = new Flower(map[0].num, map[0].cost);
            B = new Flower(map[1].num, map[1].cost);
        }

        long min = Long.MAX_VALUE;
        boolean status;
        for (int i = 0; i < A.num; i++) {
            long temp = (long) Math.ceil((double) (N - i * B.num) / A.num);

            status = false;
            if (temp < 0) {
                temp = 0;
                status = true;
            }

            min = Math.min(min, temp * A.cost + i * B.cost);
            
            if (status) {
                break;
            }
        }
        System.out.println(min);

        
    }

}