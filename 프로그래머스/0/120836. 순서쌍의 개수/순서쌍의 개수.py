def solution(n):
    answer = 0
    for i in range(1, n+1):
        # 약수만 구하는거면 제곱근까지 구하기 math.isqrt(n)은 int(math.sqrt(n))과 동일함
        if n % i == 0:
            # 나누어 떨어지면 약수
            answer+=1
    return answer