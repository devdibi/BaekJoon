import java.util.*;
import java.util.stream.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = A.length -1;
        for(int i = 0; i < idx + 1; i++){
            answer += A[i] * B[idx - i];
        }

        return answer;
    }
}