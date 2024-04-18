def solution(s):
    answer = True
    
    if s[0] == ")":
        return False
    stack = []
    for i in range(len(s)):
        if not stack:
            stack.append(s[i])
            #print(stack)
        else:
            if stack[-1] =="(" and s[i] == ")":
                stack.pop()
                #print(stack)
            else:
                stack.append(s[i])
                #print(stack)
    if stack:
        
        #print(stack)
        return False
    
    #print(stack)
    return True