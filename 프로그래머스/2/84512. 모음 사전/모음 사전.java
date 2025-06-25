import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        generate("", 0); // 백트래킹으로 단어집 생성
        //Collections.sort(dictonary); // 사전순 정렬
        dictionary.sort(Comparator.naturalOrder());
        return dictionary.indexOf(word) + 1;
    }
    
    private void generate(String current, int depth){
        if(depth > 5) return; // 최대 5글자까지만
        
        if(!current.isEmpty()){
            dictionary.add(current);
        }
        
        for(String vowel : vowels){
            generate(current + vowel, depth + 1);
        }
    }
}