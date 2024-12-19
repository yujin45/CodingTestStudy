class Solution {
    fun solution(n: Int, control: String): Int {
        val adjustments = mapOf('w' to 1, 's' to -1, 'd' to 10, 'a' to -10)
        
        return control.fold(n){acc, c ->
            acc + (adjustments[c] ?: 0)
        }
    }
}

class Solution2 {
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