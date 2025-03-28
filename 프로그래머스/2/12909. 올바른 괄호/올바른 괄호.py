def solution(s):
    if s[0] == ')':
        return False
    
    stack = []
    
    for ps in s:
        if ps == '(':
            stack.append(ps)
        elif stack and stack[-1] == '(' and ps==')':
            stack.pop()
        else:
            stack.append(ps)
            
            
    return not stack