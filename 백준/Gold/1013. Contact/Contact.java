import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int TC = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        
        // 문자열 입력
        String[] temp;

        for (int t = 0; t < TC; t++) {
            // 문자 배열로
            temp = br.readLine().split("");

            // 문자열의 길이
            int max = temp.length;

            // 포인터
            int idx = 0;

            // 0,1 판별과 전체 판별 | 0 false, 1 true
            boolean status = false, no = true;

            // 문자열 비교 작업
            while (idx < max) {
                // 초기화
                no = false;
                status = false;

                // 시작 10 패턴
                if (temp[idx].equals("1")) {
                    status = true;
                    idx++;

                    // 뒤에 값이 없는 경우 실패
                    if (idx == max) {
                        no = true;
                        break;
                    }

                    // 10 패턴 판별(통과 못하면 11 패턴임)
                    if (!temp[idx].equals("0")) {
                        no = true;
                        break;
                    }
                    status = false;

                    idx++;

                    // 뒤에 값이 없는 경우 실패
                    if (idx == max) {
                        no = true;
                        break;
                    }

                    // 100 패턴 판별
                    if (!temp[idx].equals("0")) {
                        no = true;
                        break;
                    }

                    // 100 까지는 성공
                    idx++;

                    // 뒤에 값이 없는 경우 실패
                    if (idx == max) {
                        no = true;
                        break;
                    }

                    // 100만족하고 뒤에 패턴도 존재
                    while (idx < max) {
                        // 0 패턴 출현
                        if (temp[idx].equals("0")) {
                            // status 가 true이면 앞에 1이 나왔음
                            if (status) {
                                break;
                            }
                            idx++;
                            continue;
                        }

                        // 후 1 패턴 출현
                        if (temp[idx].equals("1")) {
                            idx++;
                            status = true;
                            continue;
                        }
                    }

                    // 뒤에 값이 없는 경우 실패
                    if (idx == max && status == false) {
                        no = true;
                        break;
                    }
                    
                    // 10 패턴의 조각 종료
                }

                // 시작 01 패턴
                else if (temp[idx].equals("0")) {
                    idx++;
                    status = false;

                    // 뒤에 값이 없는 경우 실패
                    if (idx == max) {
                        no = true;
                        break;
                    }

                    // 01패턴 판별, 00일 경우 앞에 
                    if (!temp[idx].equals("1")) {
                        // 뒤가 있어야함
                        if (idx == max - 1) {
                            no = true;
                            break;
                        }

                        if (idx > 2) {
                            // 0 앞 두개가 11 패턴일 경우
                            if (temp[idx - 2].equals("1") && temp[idx - 3].equals("1")) {
                                idx -= 2;
                                continue;
                            }
                        }

                        no = true;
                        break;
                    }
                    // 1이 나옴
                    status = true;

                    idx++;

                    // 뒤에 값이 없는 경우 정상 종료
                    if (idx == max) {
                        no = false;
                        break;
                    }

                    while (idx < max) {
                        // 전 0 패턴
                        if (temp[idx].equals("0")) {
                            // 00 패턴일 경우 확인 필요
                            if (!status) {
                                // 00 앞 두개가 11 패턴일 경우
                                if (temp[idx - 2].equals("1") && temp[idx - 3].equals("1")) {
                                    idx -= 2;
                                    break;
                                }

                                no = true;
                                break;
                            }

                            idx++;

                            // 끝자리 0은 제외
                            if (idx == max) {
                                no = true;
                                break;
                            }

                            status = false;
                            continue;
                        }

                        // 후 1 패턴
                        else if (temp[idx].equals("1")) {
                            // 11패턴이므로 다음으로 넘긴다.
                            if (status) {
                                break;
                            }
                            idx++;
                            status = true;
                            continue;
                        }
                    }
                }

                if (no) {
                    break;
                }
                
            }

            if (!no) {
                ans.append("YES").append("\n");
            } else {
                ans.append("NO").append("\n");
            }
        }
        System.out.println(ans);
        
    }
}


