def solution(s1, s2):
    answer = 0
    
    for s11 in s1:
        for s22 in s2:
            if s11 == s22:
                answer+=1
    return answer