class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int idx = 0;
        String[] map = new String[n];
        
        for(int i = 0; i < n; i++){
            String num1 = Integer.toBinaryString(arr1[i]);
            String num2 = Integer.toBinaryString(arr2[i]);
            
            // 빈만큼 0으로 채우기
            num1 = fill(num1,n);
            num2 = fill(num2,n);
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(num1.charAt(j) == '0' && num2.charAt(j) == '0'){
                    sb.append(" ");
                }
                else{
                    sb.append("#");
                }
            }
            map[i] = sb.toString();
        }
        
        return map;
    }
    public String fill(String num, int n){
        int len = n - num.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append("0");
        }
        sb.append(num);
        return sb.toString();
    }
}