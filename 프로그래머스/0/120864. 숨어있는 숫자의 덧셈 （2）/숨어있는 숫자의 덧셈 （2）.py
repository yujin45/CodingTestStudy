def solution(my_string):
    # 문자 하나씩 체크가 아니라 숫자 연속으로 나오면 연속을 하나로 봄
    #return sum([int(k) for k in my_string if k.isdigit()])
    num_list = []
    num = '0'
    for m in my_string:
        if m.isdigit():
            num+=m
        else:
            num_list.append(int(num))
            num = '0'
    num_list.append(int(num)) # 마지막에 숫자 올 경우 처리
    return sum(num_list)