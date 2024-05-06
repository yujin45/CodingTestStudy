import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; // s길이 만큼
        HashMap<Character, Integer> map = new HashMap<>();
        // 글자와 인덱스 몇번째에 있는지 관리해줄 key-value
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i); // 현재 글자
            answer[i] = i - map.getOrDefault(ch, i+1); 
            // map에 없으면 자기 자신 위치- (자기자신 위치+1) 해서 -1을 저장함
            // map에 있으면 그 위치 인덱스가 반환되어 빼서 얼마나 앞에 위치해있는지 저장함
            map.put(ch, i); // 기존 값 있으면 업데이트 됨
            //System.out.println(map.entrySet()); // key-value 전체 보여줌
        }

        return answer;
    }
}