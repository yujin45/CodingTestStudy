from itertools import permutations
import math

def isPrim(num):
    if num == 0 or num == 1:
        return False
    for i in range(2, int(math.sqrt(num))+1):
        if num % i ==0:
            return False
    return True

def solution(numbers):
    answer = 0
    # 만들 수 있는 숫자의 순열 만들기
    perm = []
    for i in range(1, len(numbers)+1):
        perm += permutations(numbers, i)
    #print(perm)
    
    # 중복 제거
    perm_set = set()
    for p in perm:
        perm_set.add(int(''.join(p)))
        #perm_set.add(''.join(p))
    #print(perm_set)
    
    # 소수인지 판단하기
    for ps in perm_set:
        if isPrim(ps):
            #print(ps)
            answer+=1
    
    return answer