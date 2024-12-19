class Solution1 {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for((i, j) in queries){
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
        
        return arr
    }
}

class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { (i, j) ->
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
        return arr
    }
}