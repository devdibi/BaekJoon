import java.util.*;
import java.util.stream.*;

class Solution {
    public static class Book {
        Integer start;
        Integer end;
        
        public Integer getStart() { return start; }
        public Integer getEnd() { return end; }
        public void setStart(Integer start) { this.start = start; }
        public void setEnd(Integer end) { this.end = end; }
    }
    
    public int solution(String[][] book_time) {
        int rows = book_time.length;
        
        List<Book> schedule = new ArrayList<>();
        
        for(int i = 0; i < rows; i++) {
            Book book = new Book();
            for(int j = 0; j < 2; j++) {
                String[] split = book_time[i][j].split(":");
                if(j == 0) book.setStart(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
                if(j == 1) book.setEnd(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]) + 10);
            }
            schedule.add(book);
        }
        
        schedule = schedule.stream().sorted(Comparator.comparing(Book::getStart)).collect(Collectors.toList());
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        schedule.forEach(book -> {
            if(!rooms.isEmpty() && rooms.peek() <= book.getStart()) rooms.poll();
            rooms.offer(book.getEnd());
        });
        
        return rooms.size();
    }
}