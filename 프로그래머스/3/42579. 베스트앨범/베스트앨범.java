import java.util.*;
// TreeMap은 key 기준으로만 정렬 가능
// Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());

// Map<String, String> map = new HashMap<>();
// // value 길이 기준 내림차순 정렬
// List<Map.Entry<String, String>> sortedEntries = new ArrayList<>(map.entrySet());
// sortedEntries.sort(Comparator.comparingInt(e -> e.getValue().length()).reversed());

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, List<Song>> playsMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            genresMap.put(genre, genresMap.getOrDefault(genre, 0) + play);
            // ▼ 아래 기억하기 computeIfAbsent는 k -> 반환되는 것에 .add를 할 수 있는 것(putIfAbsent 주의)
            playsMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(genre, i, play));
        }
        
        // ▼ Map 정렬하는 방식도 기억해두기
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(genresMap.entrySet());
        sortedEntries.sort(Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed());
        
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : sortedEntries){
            String genre = entry.getKey();
            List<Song> list = playsMap.get(genre);
            list.sort(Comparator.comparingInt((Song s) -> -s.play));
            for(int i = 0; i < Math.min(2, list.size()); i++){
                answer.add(list.get(i).id);
            }
        }
        
    
        return answer.stream().mapToInt(i->i).toArray();
    }
     
}

class Song{
        int id, play;
        String genre;
        
        public Song(String genre, int id, int play){
            this.genre = genre;
            this.id = id;
            this.play = play;
        }
        
        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Song)) return false; // 상속 없을 예정이라 instanceof로 진행
            Song s = (Song) obj;
            return this.id == s.id &&
                    this.play == s.play &&
                    Objects.equals(this.genre, s.genre);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(id, play, genre);
        }
        
        @Override
        public String toString(){
            return "Song("+genre+", "+ id+", "+ play+")";
        }
        
    }

