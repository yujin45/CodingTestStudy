import math
def solution(a, b):
    answer = 0
    # 기약분수인지 판단하기
    gcd = math.gcd(a, b)
    check = b
    # 기약분수 아니면 기약분수로 만들어주기
    if gcd != 1:
        # 최대공약수가 1이면 기약분수이다.
        # 1이 아니면 확인할 분모만 최대공약수로 나눠주기
        check = b//gcd
    #print(check)
    # 분모의 소인수가 2와 5만 존재하는지 확인하기 
    # 소인수 나누기 
    i = 2
    insu = []
    while i*i <= check:
        if check % i == 0:
            # 나누어 떨어지면 소인수
            insu.append(i)
            while check%i ==0:
                # 나눠질 때까지 나누기
                check//=i
        # 나눠 떨어지지 않으면 다음 소인수로 증가
        i+=1
    # 마지막으로 남은 수가 소수인 경우
    if check > 1:
        insu.append(check)
    #print(insu)
    if 2 in insu:
        insu.remove(2)
    if 5 in insu:
        insu.remove(5)
    
    return 1 if len(insu)==0 else 2