import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] clo : clothes){
            String kind = clo[1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        int total = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            total *= (entry.getValue() + 1);
        }
        
        return total - 1;
    }
}