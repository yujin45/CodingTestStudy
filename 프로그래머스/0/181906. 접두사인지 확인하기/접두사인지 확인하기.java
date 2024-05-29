
class Solution {
    public int solution(String my_string, String is_prefix) {
        // String.startsWith(str) => String이 str로 시작하는지 판별
        if(my_string.startsWith(is_prefix)){
            return 1;
        }
        return 0;
    }
}