class Solution {
    fun solution(n: Int, control: String): Int {
        var n = n
        for(c in control){
            when(c){
                'w' -> n+=1
                's' -> n-=1
                'd' -> n+=10
                'a' -> n-=10
                else -> n
            }
        }
        return n
    }
}