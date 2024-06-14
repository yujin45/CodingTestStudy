def solution(n):
    answer = 0
    count = 0
    while count < n:
        answer +=1
        if answer % 3 ==0 or '3' in str(answer):
            # 계속 찾기!!!!
            continue
        count+=1
    return answer

