import java.util.*;

class Solution {
    public class data implements Comparable<data>{
        int[] arr;
        int len;
        
        public data(int[] arr, int len){
            this.arr = arr;
            this.len = len;
        }
        
        public int compareTo(data d){
            return Integer.compare(this.len, d.len);
        }
    }
    public int[] solution(String s) {
        // 중복 가능.
        // 순서가 있다.
        // 원소의 개수는 유한하다.
        
        // 문자열에서 집합의 외부와 내부의 순서가 변경되어도 상관없다.
        // 단, 개수에따라 순서가 정해진다.
        
        // 문자열에서 필요없는걸 삭제한다.
        // 값이 가장 많을 수록 앞에 위치
        
        // 집합 구분
        s = s.replace("},{", "/");
        
        s = s.replace("{","");
        s = s.replace("}","");
        
        // 구분을 위해 공백으로
        
        String[] temp = s.split("/");
        int[] len = new int[temp.length];
        
        List<data> list = new ArrayList<>();
        
        // 배열화 작업
        for(String str : temp){
            int idx = 0;
            String[] t = str.split(",");
            int[] a = new int[t.length];
            for(String i : t){
                a[idx++] = Integer.parseInt(i);
            }
            list.add(new data(a,a.length));
        }
        
        Collections.sort(list);
        
        List<Integer> val = new ArrayList<>();
        val.add(list.get(0).arr[0]);
        
        for(int i = 1; i < list.size(); i++){
            int[] arr = list.get(i).arr;
            
            // 이미 존재하는 값 제거
            for(int v : val){
                for(int j = 0; j < arr.length; j++){
                    if(arr[j] == v){
                        arr[j] = 0;
                        break;
                    }
                }    
            }
            
            for(int j = 0; j < arr.length; j++){
                if(arr[j] != 0){
                    val.add(arr[j]);
                }
            }
        }
        
        int[] result = new int[val.size()];
        
        int idx = 0;
        
        for(int i : val){
            result[idx++] = i;
        }
        
        return result;
    }
}