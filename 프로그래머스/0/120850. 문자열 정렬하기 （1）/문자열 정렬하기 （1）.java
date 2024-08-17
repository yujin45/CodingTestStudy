import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        List<Integer> numbers = new ArrayList<>();
        
        for(char c : my_string.toCharArray()){
            if(Character.isDigit(c)){
                numbers.add(Character.getNumericValue(c));
            }
        }
        
        Collections.sort(numbers);
        
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}