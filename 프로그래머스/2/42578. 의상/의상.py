from collections import defaultdict
def solution(clothes):
    kind_of_clothes = defaultdict(int)
    for _, kind in clothes:
        kind_of_clothes[kind] +=1
        
    answer = 1
    for _, value in kind_of_clothes.items():
        answer*=(value+1)
        
    return answer-1