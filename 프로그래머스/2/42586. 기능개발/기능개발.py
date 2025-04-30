from math import ceil

def solution(progresses, speeds):
    days = 0
    result = []
    done = 0
    for p, s in zip(progresses, speeds):
        now_need = ceil((100 - p) / s)
        if now_need > days:
            days = now_need
            result.append(done)
            done = 1
        else:
            done += 1
            
    result.append(done)
    
    return result[1:]