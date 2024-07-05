class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        var answer: Int = 0
        
        // 두 배열의 길이가 같다면
        if(arr1.size == arr2.size ){
            // 각 배열의 원소 합 비교
            var arr1sum :Int = arr1.sum()
            var arr2sum : Int = arr2.sum()
            if(arr1sum == arr2sum){
                return 0
            }else if(arr1sum > arr2sum){
                return 1
            }else{
                return -1
            }
            
        }else if(arr1.size > arr2.size){
            return 1
        }else{
            return -1
        }
        
    }
}