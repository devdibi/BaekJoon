class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        for(int i : index_list){
            sb.append(my_string.substring(i,i+1));
        }
        
        return sb.toString();
    }
}