import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        
        for(int i = 0; i < lost.length; i++){
            student[lost[i] - 1]--;
        }
        
        for(int i = 0; i < reserve.length; i++){
            student[reserve[i]-1] ++;
        }
        
        for(int i = 0; i < student.length; i++){
            // 처음 학생
            if(i == 0 && student[i] == 1){
                if(student[i+1] == -1){
                    student[i+1]++;
                    student[i]--;
                }
                continue;
            }
            // 마지막 학생
            if(i == student.length - 1 && student[i] == 1){
                if(student[i-1] == -1){
                    student[i-1]++;
                    student[i]--;
                }
                continue;
            }
            
            if(student[i] == 1){
                if(student[i-1] == -1){
                    student[i-1]++;
                    student[i]--;
                    continue;
                }
                if(student[i+1] == -1){
                    student[i+1]++;
                    student[i]--;
                }
            }
        }
        int result = 0;
        for(int i : student){
            if(i >= 0) result++;
        }
        return result;
    }
}