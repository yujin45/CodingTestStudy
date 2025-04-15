import math

def solution(progresses, speeds):
    result = []
    done = 0
    time = 0
    for p, s in zip(progresses, speeds):
        need = 100 - p - s*time
        if need > 0:
            result.append(done)
            done = 1
            time += math.ceil(need/s)
        else:
            done+=1
    result.append(done)
    
    return result[1:]