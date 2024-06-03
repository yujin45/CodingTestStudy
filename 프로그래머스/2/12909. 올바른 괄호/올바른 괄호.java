import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] a = s.toCharArray();
        for(char c : a){
            if(c=='('){
                stack.push(c);
            }else{
                // )일 경우 스택이 비어 있거나, 
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
                
                
            }
        }
        return stack.isEmpty();
    }
}