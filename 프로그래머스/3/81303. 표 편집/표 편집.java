import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 표 행 개수 n,  처음 선택된 행 위치 k, 명령어 cmd
        // 표의 행을 선택, 삭제, 복구
        // 현위치 
        int nowIndex = k;
        // 사실 이름은 필요 없음 행 번호만 변경되는 것.
       int nowSize = n;
        // z 스택
        Stack<Integer> stack = new Stack<>();
        // 표의 범위를 벗어나는 이동은 입력으로 주어지지 않습니다.
        for(String c : cmd){
            if(c.startsWith("U")){
                String[] splitCmd = c.split(" "); // 공백 기준으로 분리
                int up = Integer.parseInt(splitCmd[1]);
               // System.out.println(c);
                nowIndex -=up;
             
                //System.out.println("U nowIndex: "+nowIndex);
            }else if(c.startsWith("D")){
                String[] splitCmd = c.split(" "); // 공백 기준으로 분리
                int down = Integer.parseInt(splitCmd[1]);
                nowIndex += down;
                
               // System.out.println("D nowIndex: "+nowIndex);
            }else if(c.equals("C")){
                // 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 
                stack.push(nowIndex);
                nowSize--; // 표 줄어듦
                if(nowIndex == nowSize){
                    // 맨 아래 행 삭제해서 인덱스가 사이즈랑 겹치면 위를 선택
                    nowIndex--;
                }
               // System.out.println("C nowIndex: "+nowIndex);
            }else if(c.equals("Z")){
                // 가장 최근에 삭제된 행을 원래대로 복구합니다. 
                if(!stack.isEmpty()){
                    int insertIndex = stack.pop();
                    nowSize++;
                    if(insertIndex <= nowIndex){
                        // 삭제했던게 지금보다 전 인덱스이면
                        nowIndex++;
                    }
                }
               // System.out.println("Z nowIndex: "+nowIndex);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<nowSize; i++){
            sb.append('O');
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            sb.insert(index, 'X');
        }
        return sb.toString();
    }
}