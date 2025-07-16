
def isPrime(number):
    if number < 2:
        return False
    for i in range(2, int(number**0.5)+1):
        if number % i == 0:
            return False
    return True



    
def solution(numbers):

    visited = [False] * len(numbers)
    num_set = set()
    sequence = [""] * len(numbers)
    def backtrack(depth):
        if depth > 0:
            num = int(''.join(sequence[:depth]))
            if isPrime(num):
                num_set.add(num)
        for i in range(len(numbers)):
            if not visited[i]:
                visited[i] = True
                sequence[depth] = numbers[i]
                backtrack(depth+1)
                visited[i] = False
    
    backtrack(0)
    return len(num_set)