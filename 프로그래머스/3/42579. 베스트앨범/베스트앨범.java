import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    class Song {
        int id;
        int play;
        String genre;
        
        Song(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
    }
    
    List<Song> songs = IntStream.range(0, genres.length)
        .mapToObj(i -> new Song(i, plays[i], genres[i]))
        .collect(Collectors.toList());
    
    Map<String, Integer> genrePlayCount = songs.stream()
        .collect(Collectors.groupingBy(s -> s.genre, 
                 Collectors.summingInt(s -> s.play)));
    
    return songs.stream()
        .collect(Collectors.groupingBy(s -> s.genre))
        .entrySet().stream()
        .sorted((e1, e2) -> genrePlayCount.get(e2.getKey()) - genrePlayCount.get(e1.getKey()))
        .flatMap(e -> e.getValue().stream()
            .sorted((s1, s2) -> {
                if (s1.play != s2.play) {
                    return s2.play - s1.play;
                }
                return s1.id - s2.id;
            })
            .limit(2))
        .mapToInt(s -> s.id)
        .toArray();
    }   
}
