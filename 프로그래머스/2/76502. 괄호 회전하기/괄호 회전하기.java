import java.util.Stack;
class Solution {
    public static int isValid(String rotatedS){
        Stack<Character> stack = new Stack<>();
        int count=0;
        for(int i = 0; i < rotatedS.length(); i++){
            if(rotatedS.charAt(i) == '[' || rotatedS.charAt(i) == '(' || rotatedS.charAt(i) == '{'){
                // 괄호가 열린 것이라면 일단 넣기
                stack.push(rotatedS.charAt(i));
            }else if(rotatedS.charAt(i) == ']' || rotatedS.charAt(i) == ')' || rotatedS.charAt(i) == '}'){
                // 닫힌 괄호이면 계속 확인
                if(!stack.isEmpty() && (stack.pop() == matching(rotatedS.charAt(i)))){
                    // 비어있지 않은데 괄호 매칭 되면 올바른 괄호
                    count=1;
                }else{
                    // 비어있거나, 있는데 매칭 안되면 올바르지 못한 괄호
                    return 0;
                }
            }
            
        }
        // 모든 과정 끝내고서 스택이 비어 있어야 올바른 문장!!!!!!!!
        if(stack.isEmpty()){
            return count;
        }
        return 0;
    }
    
    public static char matching(char c){
        switch (c){
            case ']':
                return '[';
            case ')':
                return '(';
            case '}':
                return '{';
        }
        return 'a';
    }
    
    public int solution(String s) {
        int answer = 0;
        // 1칸씩 왼쪽으로 회전하면서 stack으로 검사해준다. 
        for(int x =0; x<s.length(); x++){
            // x칸씩 밀기 = 슬라이싱 해서 붙이기
            String a = s.substring(0, x);
            String b = s.substring(x, s.length());
            String rotatedS = b+a;
            //System.out.println(rotatedS);
            answer += isValid(rotatedS);
        }
        return answer;
    }

}