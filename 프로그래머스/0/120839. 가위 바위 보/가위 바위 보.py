def solution(rsp):
    # 가s 2 바r0 보p5
    answer = ''
    for k in rsp:
        if k == "2":
            answer+="0"
        elif k=="0":
            answer+="5"
        elif k =="5":
            answer+="2"

    
    return answer