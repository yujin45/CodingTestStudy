from itertools import product

def solution(word):
    # 방법 1: AEOIU를 perm 순열 -> set -> sort , 단어 찾기는 index로 찾기
    # 방법 2: backtrack으로 순열?
    
    # 방법 1로 일단 진행해보기
    alpha_dict = []
    for i in range(1, 6):
        for p in product('AEIOU', repeat=i):
            alpha_dict.append(''.join(p))
    alpha_dict.sort()
    
    return alpha_dict.index(word) + 1