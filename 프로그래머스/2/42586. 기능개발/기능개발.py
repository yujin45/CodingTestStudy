from math import ceil

def solution(progresses, speeds):
    curr_day = 0
    done = 0
    answer = []
    
    for p, s in zip(progresses, speeds):
        need_day = ceil((100 - p) / s)
        if curr_day < need_day:
            answer.append(done)
            curr_day = need_day
            done = 0
        done += 1
    
    answer.append(done)
    return answer[1:]