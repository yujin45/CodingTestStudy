from itertools import permutations

def solution(k, dungeons):
    
    n = len(dungeons)
    perm = list(permutations(dungeons, n))
    
    
    max_clear = 0
    for case in perm:
        now_k = k
        clear_count = 0
        for start, end in case:
            if start <= now_k:
                now_k -= end
                clear_count += 1
            else:
                # 진입 불가
                break
        max_clear = max(max_clear, clear_count)
            

    return max_clear