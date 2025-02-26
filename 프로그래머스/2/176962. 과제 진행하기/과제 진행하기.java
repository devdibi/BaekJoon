import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Solution {
    public static class Lecture {
        String name;
        LocalTime startTime;
        long playtime;
        
        public Lecture(String name, String startTime, String playtime) {
            this.name = name;
            this.startTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
            this.playtime = Long.parseLong(playtime);
        }
    }
    
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> LocalTime.parse(a[1]).compareTo(LocalTime.parse(b[1])));
        
        List<String> answer = new ArrayList<>();
        Stack<Lecture> stopLectures = new Stack<>();
        
        for (int i = 0; i < plans.length; i++) {
            Lecture curLecture = new Lecture(plans[i][0], plans[i][1], plans[i][2]);
            
            if (i + 1 < plans.length) {
                Lecture nextLecture = new Lecture(plans[i+1][0], plans[i+1][1], plans[i+1][2]);
                
                startCurLecture(curLecture, nextLecture, answer, stopLectures);
            } 
            else {
                answer.add(curLecture.name);
            }
        }
        
        completeStopLectures(stopLectures, answer);
        
        return answer.toArray(new String[0]);
    }
    
    private void startCurLecture(Lecture curLecture, Lecture nextLecture, List<String> answer, Stack<Lecture> stopLectures) {
        long timeBetweenLectures = ChronoUnit.MINUTES.between(curLecture.startTime, nextLecture.startTime);
        
        if (curLecture.playtime <= timeBetweenLectures) {
            completeLecture(curLecture, answer);
            
            long etcTime = timeBetweenLectures - curLecture.playtime;
            completeStopLecturesDuringBreak(stopLectures, answer, etcTime);
        } 
        else {
            curLecture.playtime -= timeBetweenLectures;
            stopLectures.push(curLecture);
        }
    }
    
    private void completeLecture(Lecture lecture, List<String> answer) {
        answer.add(lecture.name);
    }
    
    private void completeStopLecturesDuringBreak(Stack<Lecture> stopLectures, List<String> answer, long availableTime) {
        while (!stopLectures.isEmpty() && availableTime > 0) {
            Lecture stopLecture = stopLectures.pop();
            
            if (stopLecture.playtime <= availableTime) {
                availableTime -= stopLecture.playtime;
                answer.add(stopLecture.name);
            } else {
                stopLecture.playtime -= availableTime;
                stopLectures.push(stopLecture);
                break;
            }
        }
    }
    
    private void completeStopLectures(Stack<Lecture> stopLectures, List<String> answer) {
        while (!stopLectures.isEmpty()) {
            answer.add(stopLectures.pop().name);
        }
    }
}