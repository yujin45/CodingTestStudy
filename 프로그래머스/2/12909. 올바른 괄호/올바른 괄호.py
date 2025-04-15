def solution(s):
    count = 0
    for ps in s:
        if ps == '(':
            count+=1
        else:
            count-=1
        
        if count < 0:
            return False # 닫는 괄호가 먼저 오면
        
    if count != 0:
        return False # 다 돌고도 짝이 안 맞으면
    
    return True