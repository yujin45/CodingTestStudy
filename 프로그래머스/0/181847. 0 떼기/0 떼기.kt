class Solution {
    fun solution(nStr: String) = nStr.toInt().toString()
}

class Solution0 {
    fun solution(n_str: String): String {
        return n_str
            .dropWhile { it == '0' }
    }
}

/*
테스트 1 〉	통과 (0.02ms, 63.4MB)
테스트 2 〉	통과 (0.02ms, 62.2MB)
테스트 3 〉	통과 (0.02ms, 64.9MB)
테스트 4 〉	통과 (0.02ms, 64.1MB)
테스트 5 〉	통과 (0.02ms, 63.8MB)
테스트 6 〉	통과 (0.03ms, 63.5MB)
테스트 7 〉	통과 (0.02ms, 65.1MB)
테스트 8 〉	통과 (0.02ms, 61.2MB)
테스트 9 〉	통과 (0.03ms, 62.7MB)
테스트 10 〉	통과 (0.03ms, 61.8MB)
*/

class Solution1 {
    fun solution(n_str: String): String {
        if(n_str[0]!='0') return n_str
        var flag = true
        val sb = StringBuilder()
        for(n in n_str){
            if(n != '0') flag = false
            if(flag) continue
            sb.append(n)
        }
        
        return sb.toString()
    }
}

/*
테스트 1 〉	통과 (0.04ms, 64.7MB)
테스트 2 〉	통과 (0.01ms, 62.9MB)
테스트 3 〉	통과 (0.05ms, 62.1MB)
테스트 4 〉	통과 (0.05ms, 61.4MB)
테스트 5 〉	통과 (0.01ms, 63.1MB)
테스트 6 〉	통과 (0.02ms, 62.6MB)
테스트 7 〉	통과 (0.06ms, 62.3MB)
테스트 8 〉	통과 (0.03ms, 62.1MB)
테스트 9 〉	통과 (0.03ms, 63.6MB)
테스트 10 〉	통과 (0.01ms, 63.5MB)
*/
class Solution2 {
    fun solution(n_str: String): String {
        return n_str.trimStart('0')
    }
}
/*
테스트 1 〉	통과 (24.04ms, 66.2MB)
테스트 2 〉	통과 (20.89ms, 66.1MB)
테스트 3 〉	통과 (21.81ms, 65MB)
테스트 4 〉	통과 (20.45ms, 67.9MB)
테스트 5 〉	통과 (20.25ms, 66MB)
테스트 6 〉	통과 (20.31ms, 66.4MB)
테스트 7 〉	통과 (22.24ms, 65.6MB)
*/
