class Solution {
    fun solution(arr: IntArray): Int {
        var count : Int = 0
        while(true){
            val temp = arr.copyOf()
            for(i in arr.indices){
                val check = arr[i]
                if(check >= 50 && check%2 ==0){
                    arr[i] = check/2
                }else if(check < 50 && check%2 ==1){
                    arr[i]=check*2 + 1
                }
            }
            if(arr.contentEquals(temp)){ return count}
            count++
        }

        return 0
    }
}