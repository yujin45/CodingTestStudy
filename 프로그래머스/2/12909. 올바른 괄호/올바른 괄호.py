def solution(s):
    if s[0] == ')':
        return False
    
    count = 0
    for ch in s:
        if ch == '(':
            count += 1
        else:
            count -= 1
        
        if count < 0:
            return False
    
    return True if count == 0 else False