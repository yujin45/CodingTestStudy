import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // name과 yearning 목록을 만든다 
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(String[] p : photo){
            int sum = 0;
            for(String picture: p){
                 if(map.containsKey(picture)){
                     // 안에 있으면~ 
                    sum+= map.get(picture);  
                 }
            }
            list.add(sum);
            
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}