from collections import defaultdict

def solution(clothes):
    clothes_dict = defaultdict(int)
    
    for _, kind in clothes:
        clothes_dict[kind] += 1
    
    ret = 1
    
    for count in clothes_dict.values():
        ret *= (count + 1)
    
    return ret - 1