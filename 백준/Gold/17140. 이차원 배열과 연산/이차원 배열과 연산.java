import java.util.*;
import java.io.*;

public class Main {
    // comperTo를 적용한 변수
    static class Number implements Comparable<Number> {
        int idx;
        int num;

        public Number(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        public int compareTo(Number o) {
            // 개수기준 오름차순 정렬
            return this.num == o.num ? this.idx - o.idx : this.num - o.num;
        }
    }
    // 찾아야 하는 값의 index와 value
    static int r, c, k;

    // 시작 행, 열의 크기
    static int row = 3, col = 3;

    // 저장 배열과 계산 배열
    static int map[][], count[][];

    // 시간
    static int ans = 0;

    // 숫자 카운트 배열
    static int[][] visited;

    // PQ를 이용하여 다중 정렬
    static PriorityQueue<Number> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // r,c,k
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 최대 100의 크기
        map = new int[101][101];
        count = new int[101][101];

        // 입력 완료
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (ans <= 100) {
            check();
        }
        System.out.println(-1);
    }

    public static void check() {
        // 값이 일치하는지 확인
        if (map[r][c] == k) {
            System.out.println(ans);
            System.exit(0);
        }

        // 시간 추가
        ans++;

        // 연산 수행 선택
        if (row >= col) {
            R();
        } else {
            C();
        }

    }

    public static void R() {
        // 계산할 배열
        count = new int[101][101];

        // 행을 대상으로 연산 수행
        for (int i = 1; i <= 100; i++) {
            // 방문 배열 생성
            visited = new int[101][2];

            // 개수 카운트
            for (int j = 1; j <= 100; j++) {
                int temp = map[i][j];

                if (temp != 0) {
                    visited[temp][0] = temp;
                    // 개수 추가
                    visited[temp][1]++;
                }
            }

            // pq에 값이 존재하는 값 삽입(자동 정렬)
            for (int j = 1; j <= 100; j++) {
                if (visited[j][1] != 0) {
                    pq.offer(new Number(visited[j][0], visited[j][1]));
                }
            }

            int index = 1;
            // map에 배치
            while (!pq.isEmpty()) {
                Number cur = pq.poll();
                count[i][index++] = cur.idx;
                count[i][index++] = cur.num;
            }
        }
        
        // row, col 길이 구하기
        max();

        // map 초기화
        map = new int[101][101];
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (count[i][j] == 0) {
                    continue;
                }
                map[i][j] = count[i][j];
            }
        }

    }

    public static void C() {
        count = new int[101][101];

        // 열을 대상으로 연산 수행
        for (int i = 1; i <= 100; i++) {
            // 방문 배열 생성
            visited = new int[101][2];

            // 개수 카운트
            for (int j = 1; j <= 100; j++) {
                // 열을 기준으로 카운트
                int temp = map[j][i];

                if (temp != 0) {
                    visited[temp][0] = temp;
                    // 개수 추가
                    visited[temp][1]++;
                }
            }

            // pq에 값이 존재하는 값 삽입
            for (int j = 1; j <= 100; j++) {
                if (visited[j][1] != 0) {
                    pq.offer(new Number(visited[j][0], visited[j][1]));
                }
            }

            int index = 1;
            // map에 배치
            while (!pq.isEmpty()) {
                Number cur = pq.poll();
                count[index++][i] = cur.idx;
                count[index++][i] = cur.num;
            }


        }
        
        // row, col 값 구하기
        max();

        // map 초기화
        map = new int[101][101];
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (count[i][j] == 0) {
                    continue;
                }
                map[i][j] = count[i][j];
            }
        }

    }

    public static void max() {
        int tmp;
        row = 0;
        col = 0;
        // 열의 길이 구하기
        for (int i = 1; i <= 100; i++) {
            tmp = 0;
            for (int j = 1; j <= 100; j++) {
                if (count[i][j] == 0) {
                    continue;
                }
                tmp++;
            }
            col = Math.max(col, tmp);
        }

        
        // 행의 길이 구하기
        for (int i = 1; i <= 100; i++) {
            tmp = 0;
            for (int j = 1; j <= 100; j++) {
                if (count[j][i] == 0) {
                    continue;
                }
                tmp++;
            }
            row = Math.max(row, tmp);
        }
    }

}