class Solution {

    fun isCollectPS(u : StringBuilder):Boolean{
        var count = 0
        for(e in u){
            if(e=='('){
                count++
            }else if(e==')'){
                count--
            }
            if(count <0){
                return false
            }
        }
        return true
    }

    fun reversePS(ps:StringBuilder):StringBuilder{
        val sb = StringBuilder()
        for(e in ps){
            if(e=='(') sb.append(')')
            else if(e==')') sb.append('(')
        }
        return sb
    }

    fun operate(w: StringBuilder): StringBuilder{
        // 1. 입력이 빈 문자열인 경우 빈 문자열 반환
        if(w.isEmpty()) return StringBuilder()
        // 2. 문자열  w 분리
        val (u, v) = makeBalance(w)
        if(isCollectPS(u)){
            // u가 올바르면 v를 1단계부터 
            // 수행한 결과 문자열을 u에 이어 붙인 후 반환
            return u.append(operate(v))
        }else{
            val sb = StringBuilder()
            sb.append('(').append(operate(v)).append(')').append(reversePS(u.deleteCharAt(0).deleteCharAt(u.length-1)))
            return sb
        }
    }

    fun solution(p: String): String {

        return operate(StringBuilder(p)).toString()
    }

    fun makeBalance(w: StringBuilder):Pair<StringBuilder, StringBuilder>{
        var count = 0
        val sbu = StringBuilder()
        val sbv = StringBuilder()
        var isSplit = false
        for(e in w){
            if(!isSplit){
                if(e=='('){ count++ }
                else if(e==')'){ count--}
                sbu.append(e)
                if(count==0){
                    isSplit = true
                }
            }else{
                sbv.append(e)
            }
        }
        return (sbu to sbv)
    }
}