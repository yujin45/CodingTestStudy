import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 1. commands 안에 있는 명령어 순회하면서 진행해주기
        // 2. i~j까지 인덱스로 잘라서 새로운 배열 생성
        // 3. 그 배열만 정렬
        // 4. 배열의 k번째 수 뽑아서 answer에 넣기
        for(int i=0; i<commands.length; i++){
            // Arrays.copyOfRange(복사할 배열, 시작 인덱스, 끝 인덱스);
            // "시작 인덱스 ~ 끝 인덱스-1" 까지 복사됨!
            int[] subArray = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            Arrays.sort(subArray); // 오름차순 정렬
            answer[i]=subArray[commands[i][2] -1];
        }
        return answer;
    }
}