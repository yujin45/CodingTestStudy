class Solution {
    fun solution(strArr: Array<String>): Int {
        val map = mutableMapOf<Int, Int>()
        for(s in strArr){
            map[s.length] = map.getOrDefault(s.length, 0)+1
        }
        
        //return map.values.maxOrNull() ?: 0 // 컬렉션이 비어 있을 가능성이 있다면
        return map.values.maxOf{it} // 컬렉션이 비어 있지 않음을 보장할 수 있다면 →
    }
}