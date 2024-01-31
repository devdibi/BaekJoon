/*
    조건
        중복 가능. => 원소의 개수로 비교하는 로직 불가능
        순서가 있다. => 결과에 순서가 존재
        원소의 개수는 유한하다.
        문자열에서 집합의 외부와 내부의 순서가 변경되어도 상관없다.
    
    논리
        집합의 개수 기준으로 오름차순으로 정렬 후 앞단의 값을 저장하며 선택된 값을 제외한 나머지를 추가하는 방식
    
    풀이 과정
        입력이 문자열이므로 사용할 데이터 타입으로 변경한다.
        각 집합의 원소의 길이를 기준으로 정렬한다. => data class와 Comparable 활용
        리스트를 활용해 튜플 값을 저장하며 집합을 하나씩 확인하며 튜플을 완성한다.
*/

import java.util.*;

class Solution {
    // 정렬이 가능한 데이터 클래스
    public class data implements Comparable<data>{
        int[] arr;
        int len;
        
        public data(int[] arr, int len){
            this.arr = arr;
            this.len = len;
        }
        
        // 길이 값을 기준으로 정렬
        public int compareTo(data d){
            return Integer.compare(this.len, d.len);
        }
    }
    
    public int[] solution(String s) {
        // 문자열 정리 "/" 를 기준으로 집합을 구분한다.
        s = s.replace("},{", "/");
        s = s.replace("{","");
        s = s.replace("}","");
        
        String[] temp = s.split("/");
        
        int[] len = new int[temp.length];
        
        // 정렬을 위한 리스트
        List<data> list = new ArrayList<>();
        
        // 리스트에 추가 작업
        for(String str : temp){
            int idx = 0;
            String[] t = str.split(","); // 배열로 변환
            
            int[] a = new int[t.length]; // 정수 배열 생성 및 추가            
            for(String i : t){
                a[idx++] = Integer.parseInt(i);
            }
            
            list.add(new data(a,a.length)); // 리스트에 저장
        }
        
        // 길이를 기준으로 오름차순 정렬
        Collections.sort(list);
        
        // 결과 값을 추가할 리스트
        List<Integer> val = new ArrayList<>();
        
        // 초기 값 추가(비교를 위해) => 맨 처음 집합은 그냥 추가해도 무방하다.
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
            
            // 결과값에 추가
            for(int j = 0; j < arr.length; j++){
                if(arr[j] != 0){
                    val.add(arr[j]);
                }
            }
        }
        
        // 반환값 생성
        int[] result = new int[val.size()];
        
        int idx = 0;
        
        for(int i : val){
            result[idx++] = i;
        }
        
        return result;
    }
}