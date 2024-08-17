import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        // citations 배열을 내림차순으로 정렬
        List<Integer> list = Arrays.stream(citations)
                                   .boxed() // int를 Integer로 변환
                                   .sorted(Collections.reverseOrder())
                                   .collect(Collectors.toList());
        
        // H-Index를 계산
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) < (i + 1)){
                return i;
            }
        }
        
        // 모든 논문이 H-Index 조건을 만족하면, 논문의 수를 반환
        return list.size();
    }
}
