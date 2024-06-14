import math
def solution(numer1, denom1, numer2, denom2):
    # 통분해서 더하고 기약분수 만들기
    n1 = numer1 * denom2
    d1 = denom1 *denom2
    n2 = numer2 * denom1
    n = n1+n2
    gcd = math.gcd(n, d1)
    
    return [n//gcd, d1//gcd]