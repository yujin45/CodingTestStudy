from collections import Counter

def solution(participant, completion):
    return next(iter((Counter(participant) - Counter(completion))))