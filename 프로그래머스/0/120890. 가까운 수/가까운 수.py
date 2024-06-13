def solution(array, n):
    answer = 0
    temp = []
    smallest = []
    for a in array:
        temp.append(abs(a-n))
    min_ = min(temp)
    for i, t in enumerate(temp):
        if t == min_:
            smallest.append(array[i])
        
        
    return min(smallest)