import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>(); // 중복값 제거 위한 해시셋 생성
        for(int i =0; i<numbers.length-1; i++){
            for(int j = i+1; j<numbers.length; j++){
                // 두 수를 더한 값을 해시셋에 넣기
                set.add(numbers[i]+numbers[j]);
            }
        }
        // 해시셋 오름차순 정렬하고 int[] 형태 배열로 변환 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}