import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count =0;
        // board에서 move 위치에 있는 가장 위에 있는 인형 꺼내오기
        for(int m : moves){
            int doll = 0;
        B: for(int i = 0; i<board.length; i++){
                if(board[i][m-1]!=0){
                    // 인형 있으면 잡아오기 
                    doll = board[i][m-1];
                    // 잡아오고 for문 나와야 했어!!!!! 그리고 뽑은 곳 0으로 만들어줘야 했어!!
                    board[i][m-1] = 0;
                    break B;
                }
            }
            // 인형 없으면 doll =0으로 자동 설정 됨
            // 꺼내온 인형 바구니에 쌓기
            // 쌓으려는데 맨 위가 똑같은 애면 없애버리고 개수 +2 세기
            // (아니면 마지막에 pickUp한 수 - 바구니 개수)
            if(doll!=0){ // 인형 있었으면
                //System.out.println(stack.toString());
                //System.out.println("doll: " + doll);
                if(!stack.isEmpty() && doll == stack.peek()){
                    // 스택 안 비어 있으면 그리고 peek이 같으면
                    //System.out.println("doll, peek :" + doll +" " + stack.peek());
                    stack.pop();
                    count+=2;
                }else{
                    stack.push(doll);
                }
                //System.out.println(stack.toString());
            }
            
        }
        return count;
        
        
    }
}