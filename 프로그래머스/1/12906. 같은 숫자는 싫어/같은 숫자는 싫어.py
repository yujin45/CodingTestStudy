def solution(arr):
    stack = []
    
    for a in arr:
        if not stack or (stack and stack[-1] != a):
            stack.append(a)
    
    return stack