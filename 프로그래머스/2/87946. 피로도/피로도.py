from itertools import permutations

def solution(k, dungeons):
    n = len(dungeons)
    
    perm = list(permutations(dungeons, n))

    max_value = 0
    for p in perm:
        count = 0
        current_k = k
        for need, d in p:
            if current_k < need:
                break
            current_k -= d
            count+=1
        max_value = max(max_value, count)
        
    
    return max_value