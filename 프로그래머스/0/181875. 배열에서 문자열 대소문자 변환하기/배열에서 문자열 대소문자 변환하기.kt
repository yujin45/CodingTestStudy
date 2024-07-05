class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        // gpt 추천 풀이
        return strArr.mapIndexed{ index, str ->
            if(index %2 ==0 ){
                str.lowercase()
            }else{
                str.uppercase()
            }
        }.toTypedArray()
        
        // 다른 사람 풀이, 인덱스를 map으로 처리
        return strArr.indices
                    .map{ if(it%2==0){
                        strArr[it].lowercase()
                    }else{
                        strArr[it].uppercase()
                    }}.toTypedArray()
        
        // 내 풀이
        var result = mutableListOf<String>()
        for(i in strArr.indices){
            if(i%2==0){
                // 짝수는 소문자
                result.add(strArr[i].lowercase())
            }else{
                result.add(strArr[i].uppercase())
            }
        }
        return result.toTypedArray()
    }
}