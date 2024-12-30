class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val hashMap = hashMapOf<String, Int>()
        for(c in clothes){
            val category = c[1]
            hashMap[category] = hashMap.getOrDefault(category, 0) + 1
        }
        
        var answer = 1
        for(hv in hashMap.values){
           answer *=(hv+1)
        }
        return answer-1
    }
}