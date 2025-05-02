from itertools import product

def solution(word):
    perm = []
    for i in range(1, 6):
        perm += list(''.join(p) for p in product('AEIOU', repeat = i))
    perm.sort()

    return perm.index(word) + 1