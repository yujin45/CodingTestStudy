def solution(quiz):
    answer = []
    for q in quiz:
        x, op, y, _, z = q.split()
        x, y, z = int(x), int(y), int(z)
        
        if op == '+':
            calc = x + y
        else:
            calc = x - y
            
        answer.append('O' if calc == z else 'X')
    return answer