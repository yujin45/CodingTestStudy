def solution(brown, yellow):
    answer = []
    # brown yellow로 너비 구하기 
    #  테두리 1줄은 갈색
    # brown = 모서리 4개 + 위 가로 w *2 + 옆 세로 h*2
    # yellow = 위 가로 w +옆 세로 h
    #answer = [w+2, h+2]
    #brown = 4 + w*2 + h*2
    #yellow = w * h
    #brown = 4 + w*2 + (yellow//w)*2 
    #area = brown + yellow # 너비
    
    # yellow로 만들 수 있는 사각형
    if yellow ==1:
        answer = [3, 3]
        return answer
    w = 0
    h = 0
    ybox=[]
    for i in range(1, yellow+1):
        #print(i)
        if yellow == 1:
            w = 1
            h = 1
        else:
            h = i
            w = yellow //i
            #print(h, w)
            if h * w == yellow and w >= h:
                ybox.append([w, h])
                #print(ybox)

    for w, h in ybox:
        
        if brown == 4 + w*2 + h*2:
            answer = [w+2, h+2]
            #print(answer)
    # 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
    return answer