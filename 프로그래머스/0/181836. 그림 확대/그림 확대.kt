class Solution {
    fun solution(picture: Array<String>, k: Int): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val ret = mutableListOf<String>()
        val sb = StringBuilder()
        for(pic in picture){
            for(p in pic){
                repeat(k){sb.append(p)}
            }
            repeat(k){ret.add(sb.toString())}
            sb.clear()
        }
        return ret.toTypedArray()
    }
}