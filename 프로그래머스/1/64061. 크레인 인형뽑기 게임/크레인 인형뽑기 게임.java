// 전부 스택으로 구현하기
import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        // 1. 각 열에 대한 스택을 생성
        Stack<Integer> [] lanes = new Stack[board.length];
        for(int i = 0; i<lanes.length; i++){
            lanes[i] = new Stack<>();// 스택 배열에 생성
        }
         
        // 2. board를 역순으로 탐색하며, 각 열의 인형을 lanes에 추가
        for(int i = board.length -1; i>=0; i--){
            // 아래 행부터 돌기
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j]>0){
                    // 0 아니면 인형 있는 것
                    lanes[j].push(board[i][j]);
                }
            }
        }
        
        // 3. 인형을 담을 bucket 생성
        Stack<Integer> bucket = new Stack<>();
        // 4. 사라진 인형의 총 개수 저장 변수 초기화
        int answer =  0;
        
        // 5. moves 순회하며, 각 열에서 인형 뽑아 bucket에 추가
        for(int move : moves){
            if(!lanes[move-1].isEmpty()){
                // 해당 열 인형 있는 경우
                int doll = lanes[move-1].pop(); // 꺼내기
                // 6. 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if(!bucket.isEmpty() && bucket.peek() == doll){
                    bucket.pop(); // 바구니 인형 빼고
                    answer +=2; //2개 증가
                }else{
                    // 7. 바구니 안에 인형 없거나, 가장 위 인형과 다른 경우
                    bucket.push(doll); // 인형 넣기
                }
            }
        }
        return answer;
        
    }
}