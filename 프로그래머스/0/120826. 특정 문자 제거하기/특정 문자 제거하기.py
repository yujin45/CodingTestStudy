def solution(my_string, letter):
    return my_string.replace(letter, '')


def solution2(my_string, letter):
    answer = ''
    for m in my_string:
        if m != letter:
            answer+=m
    return  answer

