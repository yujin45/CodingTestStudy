def solution(my_string):
    tokens = my_string.split()
    print(tokens)
    result = int(tokens[0])
    
    for i in range(1, len(tokens), 2): # 연산자 위치 2번씩 건너 뜀
        op = tokens[i]
        num = int(tokens[i+1])
        
        if op == '+':
            result += num
        elif op == '-':
            result -= num
    
    return result
    