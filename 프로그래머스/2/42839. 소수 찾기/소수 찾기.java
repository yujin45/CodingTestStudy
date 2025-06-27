import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        backtrack(new StringBuilder(), numbers);
        //System.out.println(numberSet.toString());
        int answer = 0;
        
        for(int number : numberSet){
            if(isPrime(number)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i*i<= n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    
    private void backtrack(StringBuilder sb, String numbers){
        if(sb.length() > 0 && sb.length() <= numbers.length()){
            // 길이 1 ~ numbers.length()까지
            numberSet.add(Integer.parseInt(sb.toString()));
            if(sb.length() >= numbers.length()) return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                backtrack(sb.append(numbers.charAt(i)), numbers);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}

// import java.util.*;

// class Solution {
    
//     Set<Integer> numberSet = new HashSet<>();
//     boolean[] visited;
    
//     public int solution(String numbers) {
//         visited = new boolean[numbers.length()];
//         backtrack("", numbers);
        
//         int count = 0;
//         for(int num : numberSet){
//             if(isPrime(num)) count++;
//         }
//         return count;
//     }
    
//     // 백트래킹으로 순열 생성
//     private void backtrack(String current, String numbers){
//         if(!current.isEmpty()){
//             numberSet.add(Integer.parseInt(current));
//         }
        
//         for(int i = 0; i < numbers.length(); i++){
//             if(!visited[i]){
//                 visited[i] = true;
//                 backtrack(current + numbers.charAt(i), numbers);
//                 visited[i] = false;
//             }
//         }
//     }
    
//     // 소수 판별
//     private boolean isPrime(int n){
//         if(n < 2) return false;
//         for(int i = 2; i*i <= n; i++){
//             if(n%i==0) return false;
//         }
//         return true;
//     }
// }