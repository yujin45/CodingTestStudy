import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
        };
        
        int[] count = new int[3];
        for(int i = 0; i < answers.length; i++){
            for(int p = 0; p < pattern.length; p++){
                if(pattern[p][i%pattern[p].length] == answers[i]){
                    count[p]++;
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        int maxValue = Arrays.stream(count).max().getAsInt();
        for(int i = 0; i < count.length; i++){
            if(count[i] == maxValue){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}