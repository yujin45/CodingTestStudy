class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left;
        int[] answer = new int[len+1];
        
        int idx = 0;
        for(long i =left; i <=right; i++){
            long row = i/n; // 행
            long col = i%n; // 열
            answer[idx++] = Math.max((int)row, (int)col) +1;
        }
        
        return answer;
    }
}