def solution(n, lost, reserve):
    # 현재 학생 상태를 잃어버림 -1, 있음 0, 여분 있음 1로 표시
    student = [0] * (n+1)
    for i in range(len(lost)):
        student[lost[i]] -= 1
    for i in range(len(reserve)):
        student[reserve[i]] += 1
    
    # 학생 1번~n번까지 그리디하게 -1일 때 앞뒤 보고 있는 애한테 빌리기
    answer = 0
    for i in range(1, n+1):
        if student[i] == -1:
            # 빌려야 할 때
            if i-1 >= 1 and student[i-1] == 1:
                student[i-1] -= 1 # 빌리기
                student[i] += 1
            elif i+1 <= n and student[i+1] == 1:
                student[i+1] -= 1
                student[i] += 1
    
    answer = sum(1 for i in range(1, n+1) if student[i] >= 0)
    
    return answer