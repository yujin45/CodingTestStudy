from math import ceil
def solution(progresses, speeds):
    answer = []
    now_day = 0
    count = 0
    for p, s in zip(progresses, speeds):
        need_day = ceil((100 - p) / s)
        
        if now_day < need_day:
            answer.append(count)
            count = 1
            now_day = need_day
        else:
            count+=1
    
    answer.append(count)
    return answer[1:]