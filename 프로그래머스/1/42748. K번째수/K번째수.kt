class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        // 1. 인덱스 기준 i-1 ~ j-1까지 자르기
        // 2. 1에서 나온 것 오름차순 정렬
        // 3. 2에서 나온 배열의 인덱스 k-1 에 해당하는 숫자
        val result = IntArray(commands.size)
        for(cidx in 0 until commands.size){
            val (i, j, k) = commands[cidx]
            val temp = mutableListOf<Int>()
            for(index in i-1..j-1){
                temp.add(array[index])
            }
            result[cidx] = temp.sorted()[k-1]
        }
        //println(result.contentToString())
        return result
    }
}