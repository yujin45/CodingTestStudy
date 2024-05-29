
class Solution {
    public int solution(String my_string, String is_suffix) {
        /*
        int answer = 0;
        for(int i = 0; i< my_string.length(); i++){
            String sub = my_string.substring(i, my_string.length());
            if(sub.equals(is_suffix)){
                return 1;
            }
        }
        return 0;
        */
        if(my_string.endsWith(is_suffix)) return 1;
        return 0;
    }
}