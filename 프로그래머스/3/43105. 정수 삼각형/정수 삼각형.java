import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        if(triangle.length == 1) return triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
               if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }
        
        int answer = Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    
        return answer;
    }
}