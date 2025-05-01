def solution(array, commands):
    answer = []
    for i, j, k in commands:
        sorted_arr = sorted(array[i-1:j])
        answer.append(sorted_arr[k-1])
    return answer