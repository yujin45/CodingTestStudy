# 모든 모양 크기 수용하면서 가장 작은 사이즈
# W > H 나 H< W로 기준 잡고 교환하고서 가장 큰 값들로만 뽑아 계산하면 됨

def solution(sizes):
    answer = 0
    #print(sizes)
    for i in range(len(sizes)):
        # w > h 으로 맞춰주겠음
        # w < h 일 경우 w > h으로 교환
        if sizes[i][0] < sizes[i][1]:
            sizes[i][0] , sizes[i][1] = sizes[i][1], sizes[i][0]
    
    #print(sizes)
    max_w = max(item[0] for item in sizes)
    max_h = max(item[1] for item in sizes)
    #print(max_w, max_h)
    answer = max_w *max_h
    return answer