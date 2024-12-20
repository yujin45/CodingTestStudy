class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        return IntArray((intervals[0][1]-intervals[0][0]+1)){
            arr[it + intervals[0][0]]
        } +IntArray((intervals[1][1]-intervals[1][0]+1)){
             arr[it + intervals[1][0]]
        }
    }
}