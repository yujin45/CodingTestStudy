# 1번 : 1, 2, 3, 4, 5 반복
# 2번 : 2, 1, 2, 3, 2, 4, 2, 5 반복
# 3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복
def solution(answers):
    answer = []
    num1 = [1, 2, 3, 4, 5]
    num2 = [2, 1, 2, 3, 2, 4, 2, 5]
    num3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    a_len = len(answers)
    if a_len%len(num1) !=0:
        num1 = num1*(a_len//len(num1) +1)
    else:
        num1 = num1*(a_len//len(num1))

    if a_len%len(num2) !=0:
        num2 = num2*(a_len//len(num2) +1)
    else:
        num2 = num2*(a_len//len(num2))
        
    if a_len%len(num3) !=0:
        num3 = num3*(a_len//len(num3) +1)
    else:
        num3 = num3*(a_len//len(num3))
    #print(answers)
    #print(num1)
    #print(num2)
    #print(num3)
    ###########    
    score = [0, 0, 0]
    for i in range(len(answers)):
        if answers[i] == num1[i]:
            score[0]+=1
        if answers[i] == num2[i]:
            score[1]+=1
        if answers[i] == num3[i]:
            score[2]+=1
    #print(score)    
    s_max = max(score)
    #print(s_max)
    for i in range(len(score)):
        if s_max == score[i]:
            answer.append(i+1)
            #print(1+i)
    
    answer.sort()
    # 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    return answer