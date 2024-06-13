import math
def solution1(n):
    # math의 제곱근 구해서 보는 방법
    return 1 if math.sqrt(n).is_integer() else 2

def solution2(n):
    # 0.5승 해서 보는 방법
    return 1 if (n ** 0.5).is_integer() else 2

def solution(n):
    # 정수 제곱근만 반환하는 math.isqrt 써서 제곱하면 원래수 나오는지 확인
    return 1 if math.isqrt(n)**2==n else 2