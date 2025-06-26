/*
- N을 몇 번 써서 number를 만들 수 있는가?
- 사칙연산 사용 가능, 괄호 ok
- N은 8번까지만 사용 가능
- 최솟값 구하기 -> 최적화 문제 ->조건: n을 몇번 썼는가로 탐색 
- dp[k] = N을 K번 사용해서 만들 수 있는 숫자들의 집합
- N을 여러 번 써서 뭔가를 만든다 → "횟수 기반 DP"
*/
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        // dp[0]은 사용하지 않고 1~8만 사용
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++){
            // 같은 숫자 반복해서 만든 수 추가 (5, 55, 555)
            int repeatedNum = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatedNum);
            
            // 조합을 통해 가능한 값 추가
            for(int j = 1; j < i; j++){ // i 2개 / j 1개 / i-j는 i개 이외의 나머지에서 가져오겠다는 뜻
                for(int op1 : dp.get(j)){
                    for(int op2 : dp.get(i-j)){
                        dp.get(i).add(op1 + op2);
                        dp.get(i).add(op1 - op2);
                        dp.get(i).add(op1 * op2);
                        if(op2 != 0) dp.get(i).add(op1 / op2);
                    }
                }
            }
            if(dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}