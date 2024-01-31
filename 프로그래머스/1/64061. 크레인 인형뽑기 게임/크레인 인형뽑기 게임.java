/*
    풀이
        board의 행과 열을 전환하여 stack으로 사용
        result도 stack으로 활용
    
*/

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int cnt = 0;
        int n = board.length;
        
        Stack<Integer>[] map = new Stack[n];
        
        for(int i = 0; i < n; i++){
            map[i] = new Stack<Integer>();
            
            for(int j = n-1; j >= 0; j--){
                if(board[j][i] != 0) map[i].push(board[j][i]);
            }
        }

        Stack<Integer> result = new Stack<>();
        
        for(int i = 0; i < moves.length; i++){
            // map에 인형이 존재하는지 확인
            if(map[moves[i] -1].isEmpty()) continue;
            
            int temp = map[moves[i] -1].pop();
            
            if(result.isEmpty()){
                result.push(temp);
            }else{
                if(result.peek() == temp){
                    result.pop();
                    cnt += 2;
                }else{
                    result.push(temp);
                }
            }
        }
        
        return cnt;
    }
}