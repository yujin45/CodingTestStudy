from collections import deque

def solution(numbers, direction):
    
    dq = deque(numbers)
    
    if direction=="right":
        dq.rotate(1)
    elif direction =="left":
        dq.rotate(-1)
        
    return list(dq)