import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx =0; idx < commands.length; idx++){
            int i = commands[idx][0] - 1;
            int j = commands[idx][1];
            int k = commands[idx][2] - 1;
            
            int[] temp = new int[j-i];
            for(int subidx = i; subidx < j; subidx++){
                temp[subidx-i] = array[subidx];
            }
            Arrays.sort(temp);
            answer[idx] = temp[k];
        }
        
        return answer;
    }
}