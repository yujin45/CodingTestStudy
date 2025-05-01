from functools import cmp_to_key

def compare(a, b):
    if a + b < b + a:
        return -1
    elif a + b > b + a:
        return 1
    else:
        return 0
    
def solution(numbers):
    str_numbers = list(map(str, numbers))
    str_numbers.sort(key = cmp_to_key(compare), reverse = True)
    result = ''.join(str_numbers)
    return "0" if result[0] =="0" else result