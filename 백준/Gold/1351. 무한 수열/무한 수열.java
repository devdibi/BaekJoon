import java.util.*;
import java.io.*;

public class Main {
    // long 단위 배열 불가
    static Map<Long, Long> map = new HashMap<>();
    static long N, P, Q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        // A0 삽입
        map.put(0L, 1L);

        // An 생성
        search(N);

        System.out.println(map.get(N));
    }

    public static Long search(long N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        long num = search((long) Math.floor(N / P)) + search((long) Math.floor(N / Q));
        map.put(N, num);
        return num;
    }
}