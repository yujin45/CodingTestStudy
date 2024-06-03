import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
       // 문자열의 문자를 순서대로 스택의 peek이랑 같으면 pop하고 아니면 push하기
        
        for(int i =0; i<s.length(); i++){
            if(!stack.isEmpty()){
                // 비어 있지 않으면 진행
              
                if(stack.peek() == s.charAt(i)){
                    // 위에 확인한 것이 같으면 pop
                    stack.pop();
                }else{
                    // 다르면 넣기 push
                    stack.push(s.charAt(i));
                }
            }else{
                // 비어있으면 그냥 넣기
                stack.push(s.charAt(i));
            }
        }
        
        // stack에 남아있으면 0리턴
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }
}