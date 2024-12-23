class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        val list = mutableListOf<Int>()
        for(i in flag.indices){
            if(flag[i]){
                repeat(arr[i]*2){
                    list.add(arr[i])
                }
            }else{
                repeat(arr[i]){
                    if(list.isNotEmpty()){
                        list.removeAt(list.size -1)
                    }
                }
                //list.dropLast(arr[i])// 원본 반영 안됨
            }
        }
        return list.toIntArray()
    }
}