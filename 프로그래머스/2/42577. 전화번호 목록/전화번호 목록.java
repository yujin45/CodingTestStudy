import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        String[] sorted = Arrays.copyOf(phone_book, phone_book.length);
        Arrays.sort(sorted);
        for(int i = 0; i < sorted.length - 1; i++){
            if(sorted[i+1].startsWith(sorted[i])) return false;
        }
        return true;
    }
}