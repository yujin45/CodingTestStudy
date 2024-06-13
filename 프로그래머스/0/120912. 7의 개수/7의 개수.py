# 배열 전체를 그냥 str로 만들어주면 됐다
def solution(array):
    return str(array).count('7')

def solution2(array):
    answer = 0
    for a in array:
        answer += str(a).count('7')
    return answer