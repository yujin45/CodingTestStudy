class Solution {
    public int solution(int n) {
        // 2는 소수이므로 초기값 1로 선언
        // 이후 2부터 n의 제곱근까지 나눠주면서 소수 판별할거라 2는 따로 세어줌
        int answer = 1;
        // 3부터 n까지 검사해주기
        for(int i=3; i<=n; i++){
            if(isPrime(i)){
                answer+=1;
            }
        }
        
        return answer;
    }
    
    // 소수인지 판별해주는 함수
    private boolean isPrime(int num){
        // 2부터 n의 제곱근까지 반복하여 나누어지면 소수 아님
        for(int i =2; i<=(int)Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}