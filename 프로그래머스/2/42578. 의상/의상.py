from collections import defaultdict

def solution(clothes):
    clothes_dict = defaultdict(int)
    
    for (_, kind) in clothes:
        clothes_dict[kind]+=1
    
    comb_count = 1
    
    for v in clothes_dict.values():
        comb_count *= (v+1)

    return comb_count -1