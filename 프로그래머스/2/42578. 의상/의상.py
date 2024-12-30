from collections import Counter
def solution(clothes):
    ckinds = [ckind[1] for ckind in clothes]
    ckinds_dict = Counter(ckinds)
    value_list = list(ckinds_dict.values())
    ret = 1
    for c in value_list:
        ret *= (c+1)
    return ret-1