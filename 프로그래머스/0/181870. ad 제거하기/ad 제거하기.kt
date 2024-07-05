class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        return strArr.filterNot { it.contains("ad") }.toTypedArray()
        return strArr.filter { !it.contains("ad") }.toTypedArray()
        // 내 코드 : 순회하며 확인
        var answer = mutableListOf<String>()
        for(s in strArr){
            if("ad" !in s){
                answer.add(s)
            }
        }
        
        return answer.toTypedArray()
    }
}