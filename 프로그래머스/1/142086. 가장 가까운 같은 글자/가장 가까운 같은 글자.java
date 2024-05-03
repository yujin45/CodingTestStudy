/*
0. banana일 때
1. reverse로  ananab 만들기
2. 인덱스로 자기 자신 이후 자기 자신이 나오는 처음 위치 받기 indexOf(String, int) int번 인덱스부터 String의 인덱스 찾아 반환, 없으면 -1
3. 자신의 위치와 차이 구해서 배열에 저장해두기
4. 저장한 것 reverse로 뒤집어서 반환
*/
/*
lastIndexOf(String, int) 뒤에서 찾는 함수가 있었다! 인덱스 int부터 역순으로 탐색
*/
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char now;
        int findIndex;
        // 1. 문자열을 역순으로 탐색한다. 
        for(int i = s.length()-1; i>=0; i--){
            //System.out.print(s.charAt(i));
            // 2. 뒤에서부터 인덱스를 찾아
            // 지금 문자
            if(i==0){
                // -1
                answer[i] = -1;
                break;   
            }
            now = s.charAt(i);
            //System.out.println(now+i);
            
            findIndex = s.lastIndexOf(now, i-1);
            if(findIndex == -1){
                answer[i] = -1;
            }else{
                answer[i] = i - findIndex;
                //System.out.println(findIndex+"="+(i - findIndex));
            }
            
            
        }
        return answer;
    }
}