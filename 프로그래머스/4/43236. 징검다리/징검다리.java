import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        List<Integer> list = new ArrayList<>();
        for(int rock : rocks) list.add(rock);
        list.add(distance); // 마지막 추가
        
        int left = 1;
        int right = distance;
        int answer = 0;
        // mid는 바위 사이 거리 최솟값으로 설정
        
        while(left <= right){
            int mid = (left + right) / 2;
            int prev = 0, removed = 0;
            
            for(int rock : list){
                if(rock - prev < mid){
                    // 둘 사이 거리가 mid 이하라면, mid가 최솟값이 안되니까 바위 제거
                    removed++;
                }else{
                    prev = rock; // 최소 mid를 만족하면 다음 체크
                }
            }
            
            if(removed > n){
                // n개 넘어가게 제거해야 하면 최소 mid를 더 줄여주기
                right = mid - 1; 
            }else{
                answer = mid;
                left = mid + 1; // n개 이하 제거되면 최소 mid를 더 늘려서 mid의 최댓값 찾기
            }
        }
        

        return answer;
    }
}