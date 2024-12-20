class Solution {
    fun solution(my_string: String): IntArray {
        val counts = IntArray(52)

        for(char in my_string){
            if(char.isUpperCase()){
                counts[char - 'A']++
            }else{
                counts[char - 'a' + 26]++
            }
        }
        return counts
    }
}