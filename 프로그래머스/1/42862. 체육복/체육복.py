def solution(n, lost, reserve):
    arr = [0] * n
    # 여분 있는 사람 체크
    for r in reserve:
        arr[r - 1] += 1
    # 잃어버린 사람 체크
    for l in lost:
        arr[l - 1] -= 1
    
    # 자신의 앞 뒤를 확인하며 있는 사람 체크
    for i in range(n):
        if i == 0:
            # 뒤만 확인
            if arr[i] == -1 and arr[i+1] == 1:
                arr[i] += 1
                arr[i+1] -= 1
            
        elif i == n-1:
            if arr[i] == -1 and arr[i-1] == 1:
                arr[i] += 1
                arr[i-1] -= 1
            
        else:
            if arr[i] == -1 and arr[i-1] == 1:
                arr[i] += 1
                arr[i-1] -= 1
            elif arr[i] == -1 and arr[i+1] == 1:
                arr[i] += 1
                arr[i+1] -= 1
            
    
    return arr.count(0) + arr.count(1)