from math import ceil

def solution(progresses, speeds):
    answer = []
    count = 0
    days = ceil((100 - progresses[0]) / speeds[0])
    for p, s in zip(progresses, speeds):
        need_days = ceil((100 - p) / s)
        if days >= need_days:
            count+=1
        else:
            answer.append(count)
            count = 1
            days = need_days
    
    if sum(answer) != len(speeds):
        answer.append(count)
    
    return answer