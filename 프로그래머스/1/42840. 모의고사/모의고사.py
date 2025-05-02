def solution(answers):
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    result = [0, 0, 0, 0]
    for i in range(len(answers)):
        a = answers[i]
        if p1[i%len(p1)] == a:
            result[1] += 1
        if p2[i%len(p2)] == a:
            result[2] += 1
        if p3[i%len(p3)] == a:
            result[3] += 1
    
    answer = []
    max_value = max(result)
    for i in range(len(result)):
        if max_value == result[i]:
            answer.append(i)

    return answer