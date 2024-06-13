def solution(n):
    answer = 1
    pizza = 6
    while(True):
        if((pizza*answer)%n ==0):
            break
        else:
            answer+=1
    
    
    return answer