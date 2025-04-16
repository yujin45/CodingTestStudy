def isPrime(num):
    if num < 2:
        return False
    for d in range(2, int(num**0.5) + 1):
        if num % d == 0:
            return False
    return True

def solution(numbers):
    n = len(numbers)
    sequence = [''] * n
    visited = [False] * n
    count = 0
    num_set = set()

    def backtrack(depth):
        nonlocal count
        if depth > 0:
            num = int(''.join(sequence[:depth]))  # slicing 추가로 자릿수 제어
            if num not in num_set:
                num_set.add(num)
                if isPrime(num):
                    count += 1

        last_used = ''
        for i in range(n):
            if not visited[i] and last_used != numbers[i]:
                visited[i] = True
                sequence[depth] = numbers[i]
                last_used = numbers[i]
                backtrack(depth + 1)
                visited[i] = False

    backtrack(0)
    return count
