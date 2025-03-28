import math
def solution(progresses, speeds):
    need = []
    for i in range(0, len(speeds)):
        need.append(math.ceil((100 - progresses[i]) / speeds[i]))
    
    answer = []
    count = 1
    cneed = need[0]
    for i in range(1, len(need)):
        if cneed < need[i]:
            answer.append(count)
            count = 1
            cneed = need[i]
        else:
            count+=1
    answer.append(count)
    
    return answer