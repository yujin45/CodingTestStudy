def solution(my_string):
    result = []
    for m in my_string:
        if m not in result:
            result.append(m)
    return ''.join(result)