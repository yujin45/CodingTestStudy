import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public String[] solution(String[] record) {
        
        // 레코드를 돌면서 해시맵 생성 및 이름 변경
        // UID가 키가 되고 이름이 닉네임
        // 레코드 한바퀴 돌면서 uid:최종 닉네임 수정 완료해주기
        HashMap<String, String> map = new HashMap<>();
        for(String r : record){
            String[] command = r.split(" ");
            if(command[0].equals("Enter") || command[0].equals("Change")){
                map.put(command[1], command[2]);
            }
        }
        //System.out.println(map);
        
        ArrayList<String> answerList = new ArrayList<>();
        
        // 다시 돌면서 Enter, Leave 체크해서 문자열 만들기 
        for(String r : record){
            String[] command = r.split(" ");
            if(command[0].equals("Enter")){
                answerList.add(map.get(command[1]) + "님이 들어왔습니다.");
                
            }else if(command[0].equals("Leave")){
                answerList.add(map.get(command[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[answerList.size()];
        answer = answerList.toArray(answer);
        return answer;
    }
}