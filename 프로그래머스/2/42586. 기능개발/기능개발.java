import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> countList = new ArrayList<>();
        int days=0;
        int index=0; 
        int count = 0;
        // 인덱스로 확인, 마지막 항목까지 검사
        while(index < progresses.length){
            // days 설정하기
            if((100 - progresses[index]) % speeds[index] !=0){
                // 나머지가 생기면
                days = (100 - progresses[index]) /speeds[index] +1;
            }else{
                days = (100 - progresses[index]) /speeds[index];
            }
            // days 확인하기 
            count = 0;
            while((index < progresses.length) && ( (progresses[index] + speeds[index]*days)>=100)){
                // 작업 완료될 경우
                index++;
                count++;
            }
            countList.add(count);
            
        }
        return countList.stream().mapToInt(Integer::intValue).toArray();
    }
}