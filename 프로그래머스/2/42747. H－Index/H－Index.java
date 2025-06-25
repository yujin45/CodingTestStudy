import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        for(int i = 0; i < n ; i++){
            int h = n - i; // 현재 인덱스보다 뒤에 있는 논문 수 
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }
}