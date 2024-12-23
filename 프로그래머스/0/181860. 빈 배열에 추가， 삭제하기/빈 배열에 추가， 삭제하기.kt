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

// import java.util.*

// class Solution {
//     fun solution(arr: IntArray, flag: BooleanArray): Stack<Int> {
//         val stack = Stack<Int>()

//         for (i in arr.indices) {
//             for (j in 0 until arr[i] * if (flag[i]) 2 else 1) {
//                 if (flag[i]) stack.push(arr[i]) else stack.pop()
//             }
//         }
//         return stack
//     }
// }
