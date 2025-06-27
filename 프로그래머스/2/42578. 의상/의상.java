import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] clo : clothes){
            String kind = clo[1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        // 엔트리로 사용
        // int total = 1;
        // for(Map.Entry<String, Integer> entry : map.entrySet()){
        //     total *= (entry.getValue() + 1);
        // }
        // return total - 1;
        
        // value만 뽑아서 사용
        // int total = 1;
        // for(int count : map.values()){ // key는 map.keySet()으로 받아야 함
        //     total *= (count+1);
        // }
        // return total - 1;
        
        int total = map.values().stream()
                    .mapToInt(count -> count+1)
                    .reduce(1, (a, b) -> a*b);
        return total - 1;
    }
}