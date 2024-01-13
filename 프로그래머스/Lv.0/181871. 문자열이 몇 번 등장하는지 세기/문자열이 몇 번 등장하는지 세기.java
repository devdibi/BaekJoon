class Solution {
    public int solution(String myString, String pat) {
        return count(myString,pat);
    }
    public int count(String myString, String pat){
        int cnt = 0;
        int len = pat.length();
        for(int i = 0; i < myString.length() - len + 1; i++){
            if(myString.substring(i,i+len).equals(pat)) cnt++;
        }
        return cnt;
    }
}