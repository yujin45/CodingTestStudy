import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        // 배열 돌면서 나눠 떨어지는 것 확인
        for(int i = 0; i<arr.length; i++){
            if(arr[i]%divisor ==0){
                // 리스트에 넣기
                list.add(arr[i]);
            }
        }
        
        // 리스트 비어 있으면 -1 넣기
        if(list.isEmpty()){
            list.add(-1);
        }
        // 오름차순 정렬하기기
        Collections.sort(list);
        // 배열로 변환해서 보이기
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}