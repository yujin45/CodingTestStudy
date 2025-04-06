from collections import deque

def solution(A, B):
    if A == B:
        return 0
    
    temp = deque(A)
    
    for i in range(1, len(A)):
        temp.rotate(1)
        #print(temp)
        if ''.join(temp) == B:
            return i
    return -1