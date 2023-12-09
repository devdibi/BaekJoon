import java.util.*;
import java.io.*;

public class Solution {
    
    static List<Info> history = new ArrayList<>(); // 기록 배열
    static int n;
    static Map<String, String> member = new HashMap<>();
    
    public static class Info{
        String uid;
        Integer status;
        
        Info(String uid, Integer status){
            this.uid = uid;
            this.status = status;
        }
    }
    
    public static String[] solution(String[] record) {
         n = record.length;

        String process = "";
        String uid = "";
        String name = "";

        for(int i = 0; i < n; i++){
            String[] temp = record[i].split(" ");

            process = temp[0];
            uid = temp[1];

            if(!process.equals("Leave")){
                name = temp[2];
            }
            
            if(process.equals("Enter")){
                enter(uid,name);
            }else if(process.equals("Leave")){
                leave(uid);
            }else if(process.equals("Change")){
                change(uid,name);
            }
        }
        
        String[] answer = new String[history.size()];
        
        int idx = 0;
        
        for(Info i : history){
            String text = member.get(i.uid) + "님이 " + (i.status == 1 ? "들어왔습니다." : "나갔습니다.");
            answer[idx++] = text;    
        }
        
        
        return answer;
    }
    
    // 입장
    public static void enter(String uid, String name){
        // 기존에 기록이 존하는 경우 변경해야함
        if(search(uid)){
            change(uid,name);
        }else{
            member.put(uid,name);
        }
        
        history.add(new Info(uid,1));      
    }

    // 퇴장
    public static void leave(String uid){
        history.add(new Info(uid,0));
    }
    
    // 변경
    public static void change(String uid, String name){
        // member 이름 변경
        member.replace(uid,name);
    }
    
    // member 존재 여부 파악
    public static boolean search(String uid){
        if(member.get(uid) == null){
            return false;
        }
        return true;
    }
    
}

// uid에 대한 닉네임을 변경하고 history 배열에는 여부만

