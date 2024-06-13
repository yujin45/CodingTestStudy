def solution(before, after):
    answer = 0
    for b in before:
        if b in after:
            after = after[:after.find(b)] + after[after.find(b)+1:] # 확인된 것 1개만 제거
    return 1 if len(after)==0 else 0