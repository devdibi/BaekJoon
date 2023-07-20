import java.util.*;
import java.io.*;

public class Main {
    static int M, N, L;
    static int[] x;
    static Loc[] animal;
    static int count = 0;
    static class Loc {
        int x, y;
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        x = new int[M];

        // 사대
        st = new StringTokenizer(br.readLine());

        // 사대 X좌표
        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        // 사대 정렬
        Arrays.sort(x);

        // 동물의 좌표
        animal = new Loc[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            animal[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 동물 정렬
        Arrays.sort(animal, (o1, o2) -> o1.x - o2.x);

        // 동물을 기준 / 사대 이분탐색
        for (int i = 0; i < N; i++) {
            int l = 0;
            int r = M - 1;
            int m = (l + r) / 2;

            // 안되는것 삭제
            if (animal[i].y > L) {
                continue;
            }

            // 사대 파악
            while (l <= r) {
                if(Math.abs(animal[i].x - x[m]) <= L - animal[i].y){
                    count++;
                    break;
                }
                // 사대의 위치가 동물의 왼쪽에 위치
                if (animal[i].x  > x[m]) {
                    l = m + 1;
                    m = (l + r) / 2;
                    continue;
                }

                // 사대의 위치가 동물의 오른쪽 위치
                if (animal[i].x < x[m]) {
                    r = m - 1;
                    m = (l + r) / 2;
                    continue;
                }

                // 사대의 위치가 동물의 위치와 동일
                if (animal[i].x == x[m]) {
                    count++;
                    break;
                }
            }
        }
        
        System.out.println(count);
        
    }
}