
def solution(s):
    s_set = set(s)
    voca = {}
    result = []
    for ch in s_set:
        voca[ch] = s.count(ch)
    for key, value in voca.items():
        if value == 1:
            result.append(key)
    return ''.join(sorted(result))
    