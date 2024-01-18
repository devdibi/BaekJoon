class Solution {
    int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    public String solution(int a, int b) {
        int sum = 4 + b;
        
        for(int i = 1; i < a; i++){
            sum+= month[i];
        }
        
        return day[sum % 7];
    }
}