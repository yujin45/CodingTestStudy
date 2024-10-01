class Solution {
    fun collatz(num : Long ,count:Int) : Int{
        if(count>500) return -1
        if(num == 1L) return count
        
        val nextNum = if(num %2 == 0L){
            num/2
        }else{
             num * 3 +1
        }
        
        return collatz(nextNum, count+1)
        
    }
    fun solution(num: Int): Int {
        
        return collatz(num.toLong(), 0)
    }
}