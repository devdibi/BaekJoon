class Solution {
    public String[] solution(String[] strArr) {
        String[] result = new String[strArr.length];
        
        int idx = 0;
        
        for(String s : strArr){
            result[idx++] = idx % 2 == 0 ? s.toUpperCase(): s.toLowerCase();
        }
        
        return result;
    }
}