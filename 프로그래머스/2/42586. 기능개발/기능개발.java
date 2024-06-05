import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> countList = new ArrayList<>(); // 배포 개수
        int days = 0;
        int count = 0;
        int index = 0;
        
        while(index < progresses.length) {
            // 새로운 days 구하기
            if(((100 - progresses[index]) % speeds[index]) != 0) {
                // 나누어 떨어지지 않으면 
                days = ((100 - progresses[index]) / speeds[index]) + 1; 
            } else {
                days = ((100 - progresses[index]) / speeds[index]);
            }
            
            // 같은 기간에 배포할 작업 개수 세기
            count = 0;
            while(index < progresses.length && (progresses[index] + speeds[index] * days) >= 100) {
                count++;
                index++;
            }
            countList.add(count);
        }
        
        return countList.stream().mapToInt(Integer::intValue).toArray();
    }
}
