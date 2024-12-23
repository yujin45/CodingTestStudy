import java.util.Deque
import java.util.ArrayDeque

class Solution {
    fun solution(arr: IntArray): IntArray {
        val stk: Deque<Int> = ArrayDeque()
        
        var i = 0
        while(i < arr.size){
            if(stk.isEmpty()){
                stk.push(arr[i])
                i++
            }else{
                if(stk.peek() == arr[i]){
                    stk.pop()
                    i++
                }else{
                    stk.push(arr[i])
                    i++
                }
            }
        }
        
        return if (stk.isEmpty()) intArrayOf(-1) else stk.toIntArray().reversedArray()
    }
}