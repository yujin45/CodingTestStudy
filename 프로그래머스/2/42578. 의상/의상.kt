class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 0
        val kindCount = HashMap<String, Int>()
        for((_, kind) in clothes){
            kindCount[kind] = kindCount.getOrDefault(kind, 0) +1
        }
        // 조합 공식으로 풀기
        var result = 1
        for((key, value) in kindCount.entries){
            //println("key : $key, value : $value")
            result *=(value+1)
        }
        return result-1
    }
}