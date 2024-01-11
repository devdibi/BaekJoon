class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String str = age+"";
        
        for(int i = 0; i < str.length(); i++){
            sb.append(Character.toString(str.charAt(i) + 49));
        }
        
        return sb.toString();
    }
}