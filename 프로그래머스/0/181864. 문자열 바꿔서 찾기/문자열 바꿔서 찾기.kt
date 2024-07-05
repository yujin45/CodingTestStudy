class Solution {
    fun solution(myString: String, pat: String): Int {
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