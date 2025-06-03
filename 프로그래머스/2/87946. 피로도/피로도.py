from collections import deque
from itertools import permutations

def solution(k, dungeons):
    n = len(dungeons)
    perm = list(permutations(dungeons, n))

    answer = -1
    for case in perm:
        count = 0
        current = k
        for need, lose in case:
            if current >= need:
                current -= lose
                count+=1
            else:
                break
        answer = max(answer, count)
    
    
    return answer