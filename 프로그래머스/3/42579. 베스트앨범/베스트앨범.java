import java.util.*;

class Song{
    int id;
    int play;
    
    public Song(int id, int play){
        this.id = id;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genMap = new HashMap<>(); // 장르별 총 재생수
        Map<String, List<Song>> musicMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            String gen = genres[i];
            int play = plays[i];
            
            genMap.put(gen, genMap.getOrDefault(gen, 0) + play);
            
            musicMap.computeIfAbsent(gen, k -> new ArrayList<>()).add(new Song(i, play));
        }
        
        // 장르별 정렬
        List<String> sortedGenres = new ArrayList<>(genMap.keySet());
        sortedGenres.sort((a, b) -> genMap.get(b) - genMap.get(a)); // 내림차순
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre: sortedGenres){
            List<Song> songList = musicMap.get(genre);
            // 노래 정렬
            songList.sort((s1, s2) -> {
                if(s1.play != s2.play) return s2.play - s1.play;
                else return s1.id - s2.id;
            });
            
            // 최대 2개 수록
            for (int i = 0; i < Math.min(2, songList.size()); i++){
                result.add(songList.get(i).id);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}