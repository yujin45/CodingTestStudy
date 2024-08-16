import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 종류 당 : 종류 개수 + 1 (안 입을 경우)
        // 각 종류 별 곱하여 조합 구하기 그 후 1 빼기(아무것도 안 입을 경우)
        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            // 같은 이름 가진 의상 존재 X // 아무것도 안 입을 경우 1을 디폴트
            map.put(c[1], map.getOrDefault(c[1], 1) + 1);
        }
        
        for(int count : map.values()){
            answer *=count;
        }
       
        
        return answer-1;
    }
}