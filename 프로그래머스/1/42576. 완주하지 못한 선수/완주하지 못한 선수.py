from collections import Counter

def solution(participant, completion):
    p = Counter(participant)
    c = Counter(completion)
    d = p - c
    #return list(d.keys())[0]
    return next(iter(d))