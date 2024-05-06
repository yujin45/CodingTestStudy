class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        answer = (end - start +1) *(start+end)/2;
        return answer;
    }
}