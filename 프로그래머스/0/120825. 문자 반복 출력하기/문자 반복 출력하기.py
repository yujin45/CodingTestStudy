def solution(my_string, n):
    answer = ''
    for m in my_string:
        answer+=(m*n)
    return answer