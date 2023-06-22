import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char word[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        int start, end, status, len;
        for (int i = 0; i < N; i++) {
            word = br.readLine().toCharArray();

            // 시작 세팅
            len = word.length;
            start = 0;
            end = len - 1;
            status = 0;

            while (true) {
                // 종료조건(검색 범위 완료)
                if (start > (len - 1) / 2 || end < (len - 1) / 2) {
                    sb.append(status).append("\n");
                    break;
                }

                // 일치하는 경우
                if (word[start] == word[end]) {
                    start++;
                    end--;
                    continue;
                }

                // 일치하지 않는 경우
                if (word[start + 1] != word[end] && word[start] != word[end - 1]) {
                    status = 2;
                    sb.append(status).append("\n");
                    break;
                }

                // 앞단
                if (word[start + 1] == word[end]) {
                    status = front(word, start, end);
                }

                // 뒷단
                if (status != 1 && word[start] == word[end - 1]) {
                    status = back(word, start, end);
                }


                sb.append(status).append("\n");
                break;
            }

        }
        System.out.println(sb);
    }

    public static int front(char[] word, int start, int end) {
        start++;
        while (true) {
            if (start > word.length / 2 || end < word.length / 2) {
                return 1;
            }
                
            if (word[start] == word[end]) {
                start++;
                end--;
                continue;
            }
            return 2;
        }
    }
    
    public static int back(char[] word, int start, int end) {
        end--;
        while (true) {
            if (start > word.length / 2 || end < word.length / 2) {
                return 1;
            }

            if (word[start] == word[end]) {
                start++;
                end--;
                continue;
            }

            return 2;
        }
    }
}