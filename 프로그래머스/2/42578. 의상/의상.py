from collections import defaultdict

def solution(clothes):
    clothes_dict = defaultdict(int)
    for _, kind in clothes:
        clothes_dict[kind] += 1

    result = 1
    for _, value in clothes_dict.items():
        result *= (value + 1)
    
    return result - 1