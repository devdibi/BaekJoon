import java.util.*;
import java.io.*;

public class Main {
    static int N, W, T, K; // 모닥불의 개수, 시작 위치, 시간, 최소 개수
    static int map[];      // 모닥불의 시작
    static int wood[];     // 시간마다 장작의 번호
    static int process[];  // 화력 감소 상황 배열
    static int temp[];     // 화력 감소 수준 판별 배열
    static int cur = -1;    // 현재 장작의 위치
    static int ans = 0;    // 경우의 수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 모닥불의 개수
        W = Integer.parseInt(st.nextToken())+1; // 시작 위치
        T = Integer.parseInt(st.nextToken()); // 시간
        K = Integer.parseInt(st.nextToken()); // 최소 개수

        wood = new int[T + 1]; 
        map = new int[N + 1];
        process = new int[N + 1];
        temp = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        // ---- 입력 완료 ----
        wood[0] = W; // 시작 위치에 대한 정보 저장
        site(1); // 1번 열부터 시작 
        System.out.println(ans);
    }
    // 모닥불의 화력 감소
    public static void down(int time) {
        int size = 3;
        // 소화 전 배열 복제
        for (int i = 1; i <= N; i++) {
            temp[i] = process[i];
        }

        // 전체 소화
        for (int i = 1; i <= N; i++) {
            size = 3;
            // 지난번에 장작 추가한 경우 제외
            if (cur == i) {
                continue;
            }

            // 판별
            if (i > 1 && i < N) {
                if (process[i - 1] > 0) {
                    size -= 1;
                }
                if (process[i + 1] > 0) {
                    size -= 1;
                }
            } else if (i == N) {
                if (process[i - 1] > 0) {
                    size -= 1;
                }
            } else if (i == 1) {
                if (process[i + 1] > 0) {
                    size -= 1;
                }
            }
            // 소화
            temp[i] -= size;
        }

        // 현재 나무 위치 갱신
        cur = wood[time];

        // 현재 모닥불 상황 갱신
        for (int i = 1; i <= N; i++) {
            process[i] = temp[i];
        }
    }
    
    // 시간마다 장작을 넣을 위치 생성(마지막은 생성할 필요가 없다.)
    public static void site(int time) {
        if (time == T) {
            if (!check()) {
                return;
            }

            // map => process
            for (int i = 1; i <= N; i++) {
                process[i] = map[i];
            }
            
            cur = -1; // 최초 시작 시 제외

            for (int i = 1; i <= T; i++) {
                down(i);
            }
            
            if (min()) {
                ans++;
            }

            return;
        }

        // 장작의 위치 선정
        for (int i = 1; i <= N; i++) {
            wood[time] = i;
            site(time + 1);
            wood[time] = 0;
        }
    }
    
    // 유효성 판별
    public static boolean check() {
        // 시작 위치와 처음 장작의 위치의 거리가 멀 경우 제외
        for (int i = 1; i < T; i++) {
            if (Math.abs(wood[i] - wood[i - 1]) > 1) {
                return false;
            }
        }
        return true;
    }

    // 최소 판별
    public static boolean min() {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (process[i] > 0) {
                count++;
            }
        }

        if (count < K) {
            return false;
        }

        return true;
    }
}

