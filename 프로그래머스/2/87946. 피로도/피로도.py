from itertools import permutations

def solution(k, dungeons):
    perm = list(permutations(dungeons, len(dungeons)))
    max_count =0
    for duns in perm:
        count = 0
        now = k
        for need, minus in duns:
            if now >= need:
                now -= minus
                count+=1
            else:
                break
        max_count = max(count, max_count)
    return max_count 