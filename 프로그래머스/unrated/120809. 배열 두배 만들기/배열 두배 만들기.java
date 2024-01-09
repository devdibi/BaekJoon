class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        for(int i : numbers) answer[idx++] = i * 2;
        
        return answer;
    }
}