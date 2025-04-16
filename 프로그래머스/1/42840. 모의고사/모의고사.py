
def solution(answers):
    p_list = [0, 0, 0, 0]
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for i in range(len(answers)):
        if p1[i % len(p1)] == answers[i]:
            p_list[1] += 1
        if p2[i % len(p2)] == answers[i]:
            p_list[2] += 1
        if p3[i % len(p3)] == answers[i]:
            p_list[3] += 1
    
    result = []
    max_val = max(p_list)
    for i in range(1, len(p_list)):
        if p_list[i] == max_val:
            result.append(i)
    result.sort()
    return result