class Solution {
    fun solution(topping: IntArray): Int {
        
        val toppingCount = IntArray(10_001) // 토핑 개수
        var rightCount = 0
        var leftCount = 0
        var result = 0
        for(t in topping){
            if(toppingCount[t]==0){
                // 없던 종류이면 right의 종류 증가
                rightCount++
            }
            toppingCount[t] +=1 // 토핑 개수 증가
        }
        
        val seen = BooleanArray(10_001) // left가 가지고 있는지 확인용
        // left가 하나씩 종류 가져오면서 left = right 종류 개수 같으면 result ++해주기
        for(i in topping.indices){
            if(!seen[topping[i]]){
                // 새로운 종류면
                leftCount++
                seen[topping[i]]= true
            }
            toppingCount[topping[i]]--// 개수 줄이기
            if(toppingCount[topping[i]]==0) rightCount--
            if(leftCount==rightCount) result++
        }
        
        return result
    }
}