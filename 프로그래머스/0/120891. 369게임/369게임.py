def solution(order):
    order = str(order)
    answer = order.count('3') + order.count('6') + order.count('9')
    return answer

def solution1(order):
    answer = 0
    for s in str(order):
        if s in ['3', '6', '9']:
            answer+=1
    return answer

