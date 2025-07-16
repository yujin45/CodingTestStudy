from itertools import permutations

def solution(k, dungeons):
    perm = list(permutations(dungeons, len(dungeons)))
    
    max_dun = -1
    
    for p in perm:
        now_k = k
        count = 0
        for need, minus in p:
            if now_k >= need:
                now_k -= minus
                count+=1
            else:
                break
        max_dun = max(max_dun, count)
        
    
    return max_dun