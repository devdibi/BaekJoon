import java.util.*;

class Solution {
    static int result, maxHealth;
    static int save = 0;
    
    static int t,x,y;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 전역변수 지정
        result = health;
        maxHealth = health;
        
        t = bandage[0];
        x = bandage[1];
        y = bandage[2];
        
        int maxTime = attacks[attacks.length-1][0];
        int attackIdx = 0;
        
        for(int i = 1; i <= maxTime; i++){
            if(i != attacks[attackIdx][0]){
                heal();
            }
            
            else{
                attack(attacks[attackIdx][1]);
                attackIdx++;
            }
            
            if(result <= 0){
                break;
            }
            
            System.out.println(i +" " +result);
        }
        int answer = 0;
        
        if(result <= 0){
            answer = -1;    
        }else{
            answer = result;
        }
        
        return answer;
    }
    
    // 회복하는 메서드
    // 최대 체력은 넘을 수 없음
    public void heal(){
        // hp 회복
        result += x;
        
        // 최대 체력 초과 안됨
        if(result > maxHealth){
            result = maxHealth;
        }
        
        // 연속 치료시간 증가
        save++;
        
        // 최대 시간 회복 메서드
        if(save == t){
            fullHeal();
        }
    }
    
    // 최대 시간 회복 메서드
    public void fullHeal(){
        // 추가 체력 추가
        result += y;
        
        // 시간 초기화
        save = 0;
    }
    
    // 공격 당하는 메서드
    public void attack(int attack){
        // 피해량 계산
        result -= attack;
        
        // 연속 치료 시간 초기화
        save = 0;
    }
}