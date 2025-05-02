from itertools import permutations

def isPrime(num):
    if num <= 1:
        return False
    for i in range(2, int(num**0.5)+1):
        if num % i == 0:
            return False

    return True
    
    
def solution(numbers):
    perm = []
    for i in range(1, len(numbers) + 1):
        perm.extend(set(int(''.join(p)) for p in (permutations(numbers, i))))

    perm = set(perm)
    count = 0
    for p in perm:
        if isPrime(p):
            count+=1
    
    return count