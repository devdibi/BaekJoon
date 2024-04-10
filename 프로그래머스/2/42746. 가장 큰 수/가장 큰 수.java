import java.util.*;

class Solution{
    public class Num implements Comparable<Num>{
        String num;
        
        public Num(int n){
            this.num = String.valueOf(n);
        }
        
        // 조합의 값 비교
        public int compareTo(Num n){
            // 시간 감소를 위한 코드
            int min = Math.min(n.num.length(), this.num.length());
            
            for(int i = 0; i < min; i++){
                // 같지 않으면 정렬
                if(comp(n.num.charAt(i), this.num.charAt(i)) != 0) return comp(n.num.charAt(i), this.num.charAt(i));
            }
            
            // 모두 같고 길이도 같으면 정렬 X
            if(n.num.length() == this.num.length()) return 0;
            
            // 모든 경우에 사용 가능 조건(단, 문자열 연산으로 느리다)
            return Integer.compare(Integer.parseInt(n.num+this.num), Integer.parseInt(this.num+n.num));
        }
        
        public int comp(char a, char b){
            return Character.compare(a,b);
        }
    }
    
    public String solution(int[] numbers) {
        int len = numbers.length;
        
        // 모두 객체로 변경
        Num[] nums = new Num[len];
        
        int idx = 0;
        
        for(int n : numbers){
            nums[idx++] = new Num(n);
        }
        
        // 정렬
        Arrays.sort(nums);
        
        // 가장 앞의 값이 0이면 그냥 0이다.
        if(nums[0].num.equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < len; i++){
            sb.append(nums[i].num);
        }
        
        return sb.toString();
    }
}