class Solution {
    fun solution(myString: String, pat: String): Int {
        // map, joinToString 사용
        val convertedString = myString.map{
            when(it){
                'A' -> 'B'
                'B' -> 'A'
                else -> it
            }
        }.joinToString("")
        return if(pat in convertedString) 1 else 0
        
        // 내 코드
        // 하나씩 바꿔주기
        var reverse : String = ""
        for(m in myString){
            if(m == 'A'){
                reverse += "B"
            }else{
                reverse += "A"
            }
        }
        
        return if(pat in reverse) 1 else 0
    }
}