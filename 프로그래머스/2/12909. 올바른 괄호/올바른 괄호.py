def solution(s):
    if s[0] == ')':
        return False
    elif s[-1] == '(':
        return False
    else:
        count = 0
        for ps in s:
            if ps == '(':
                count+=1
            elif ps == ')':
                count -=1
            if count < 0:
                return False
        return True if count == 0 else False