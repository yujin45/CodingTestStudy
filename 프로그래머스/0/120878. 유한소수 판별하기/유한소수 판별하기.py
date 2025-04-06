import math

def solution(a, b):
    # 1. 기약분수 만들기
    gcd_num = math.gcd(a, b)
    b_ = b // gcd_num

    # 2. 분모에서 2와 5 계속 제거
    for p in [2, 5]:
        while b_ % p == 0:
            b_ //= p
    
    # 3. 제거하고 남은 것 1이면 유한 소수
    return 1 if b_ == 1 else 2