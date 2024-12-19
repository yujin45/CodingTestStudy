class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk = mutableListOf<Int>()
        var i = 0
        while(i < arr.size){
            if(stk.isEmpty()){
                stk.add(arr[i])
                i+=1
            }else if(stk.last() < arr[i]){
                stk.add(arr[i])
                i+=1
            }else{
                stk.removeAt(stk.lastIndex)
            }
        }
        return stk.toIntArray()
    }
}

