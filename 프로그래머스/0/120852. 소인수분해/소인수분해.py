def solution(n):
    i = 2
    answer = []
    
    # 2부터 n의 제곱근까지 시도
    while i*i <= n:
        # i로 나눠 떨어지면 소인수
        if n % i ==0:
            answer.append(i)
            while n % i ==0:
                # 최대한 나눌 수 있을 때까지 나누기
                n//=i
        # 나눠 떨어지지 않으면 증가
        i+=1
    
    # 마지막으로 남은 수가 소수인 경우
    if n > 1:
        answer.append(n)
    
    set_answer = set(answer)
    sortee_answer = sorted(list(set_answer))
    return sortee_answer 