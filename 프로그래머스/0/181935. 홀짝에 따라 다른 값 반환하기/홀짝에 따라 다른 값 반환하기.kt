class Solution {
    fun solution(n: Int): Int {
        return if(n%2 == 1){ // n이 홀수라면
            (1..n step 2).sum() // 1부터 n까지 홀수만 합산
        } else { // n이 짝수라면
            (2..n step 2).sumOf{it*it} // 2부터 n까지 짝수의 제곱 합산
        }
    }
}