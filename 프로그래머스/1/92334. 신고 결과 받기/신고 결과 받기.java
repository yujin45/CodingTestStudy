import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 당한 유저 - 신고 유저 집합을 저장할 해시 맵
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        HashMap<String, Integer> count = new HashMap<>();
        
        // 1. 신고 기록 순회 
        for(String r : report){
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];
            
            if(!reportedUser.containsKey(reportedId)){
                // 2. 신고 당한 기록이 없다면
                reportedUser.put(reportedId, new HashSet<>());
            }
            // 3. 신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUser.get(reportedId).add(userId);
        }
        /// 나랑은 다르게 [신고당한 사람 : 신고한 사람1, 신고한 사람2] 으로 저장하고 있음
        // 그래서 아래 보면 신고한 사람의 숫자로 몇명에게 신고당했는지 판별함
        for(Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()){
            if(entry.getValue().size() >= k){
                // 4. 정지 기준 만족하는지 확인
                // 정지되는 신고 당한 사람이면 : 해당 신고한 사람 1~n명에게 1을 더해줌
                for(String uid: entry.getValue()){
                    // 5. 해시셋을 순회하며 count 계산
                    count.put(uid, count.getOrDefault(uid, 0) +1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        // 6. 각 아이디별 메일을 받은 횟수를 순서대로 정리
        for(int i = 0; i < id_list.length; i++){
            answer[i]  = count.getOrDefault(id_list[i], 0); 
        }
        return answer;
        
    }
}