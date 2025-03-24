import java.util.*;

class Solution {
    public static class Play {
        int idx;
        int count;
        
        public Play(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
    
    public static class Genre {
        String name;
        Queue<Play> playList = new PriorityQueue<>((p1, p2) -> {
            if(p1.count != p2.count) {
                return p2.count - p1.count;  
            }
            return p1.idx - p2.idx;          
        });
        int total;  
        
        public Genre(String name) {
            this.name = name;
            this.total = 0;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genreName = genres[i];
            int play = plays[i];
            
            Genre genre = genreMap.getOrDefault(genreName, new Genre(genreName));
            genre.playList.add(new Play(i, play));
            genre.total += play;
            
            genreMap.put(genreName, genre);
        }
        
        List<Genre> genreList = new ArrayList<>(genreMap.values());
        genreList.sort((g1, g2) -> g2.total - g1.total);
        
        List<Integer> answer = new ArrayList<>();
        
        for(Genre genre : genreList) {
            int count = 0;
            while(!genre.playList.isEmpty() && count < 2) {
                answer.add(genre.playList.poll().idx);
                count++;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}