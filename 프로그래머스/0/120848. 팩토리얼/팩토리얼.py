from math import factorial

def solution(n):
    answer=1
    while factorial(answer) <= n:
        answer+=1
    return answer-1

####
def fact(n):
    if n == 1:
        return 1
    return n * fact(n-1)
    
def solution2(n):
    answer = 1
    while(True):
        if fact(answer) > n:
            return answer -1
        answer+=1
    return answer