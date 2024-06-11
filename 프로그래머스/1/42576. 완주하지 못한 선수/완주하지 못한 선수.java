import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map  = new HashMap<>();
        
        for(String name : participant){
            // getOrDefault : 가져와서 없으면 default 값 넣어줌
            map.put(name, map.getOrDefault(name, 0) +1);
        }
        for(String name: completion){
            // 값 가져와서 1 빼주기
            map.put(name, map.get(name) -1); 
        }
        
        String answer = "";
        for(String name : map.keySet()){
            if(map.get(name)!=0){
                answer = name;
            }
        }
        return answer;
    }
}